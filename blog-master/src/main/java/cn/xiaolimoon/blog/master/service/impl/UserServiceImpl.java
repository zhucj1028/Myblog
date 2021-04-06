package cn.xiaolimoon.blog.master.service.impl;

import cn.xiaolimoon.blog.master.mapper.PermissionMapper;
import cn.xiaolimoon.blog.master.mapper.UserMapper;
import cn.xiaolimoon.blog.master.mapper.UserRoleMapper;
import cn.xiaolimoon.blog.master.model.Permission;
import cn.xiaolimoon.blog.master.model.User;
import cn.xiaolimoon.blog.master.model.UserRole;
import cn.xiaolimoon.blog.master.schedule.CacheSchedule;
import cn.xiaolimoon.blog.master.security.UserInfo;
import cn.xiaolimoon.blog.master.service.IUserService;
import cn.xiaolimoon.blog.master.service.ex.InsertException;
import cn.xiaolimoon.blog.master.service.ex.PhoneDuplicateException;
import cn.xiaolimoon.blog.master.service.ex.UsernameDuplicationException;
import cn.xiaolimoon.blog.master.vo.UserListVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuqu
 * @since 2020-12-09
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registerUser(User user) {
        // 【由于当前项目设计的规则是“用户账号通过手机号码注册、登录”，必须保证手机号码唯一】
        // 通过参数user获取尝试注册的用户名
        String nickname = user.getNickname();
        // 调用UserMapper对象的selectOne()方法，根据昵称号码查询用户账号信息
        QueryWrapper<User> nameQueryWrapper = new QueryWrapper<>();
        nameQueryWrapper.eq("nickname", nickname);
        User resultNickname = userMapper.selectOne(nameQueryWrapper);
        // 判断查询结果是否不为null
        if (resultNickname != null) {
            // 是：查询到了数据，表示用户名已经被占用，则抛出UsernameDuplicationException
            throw new UsernameDuplicationException("注册失败！ 该昵称已经被注册！");
        }
        // 从参数user中取出手机号码
        String phone = user.getPhone();
        // 调用UserMapper对象的selectOne()方法，根据手机号码查询学生账号信息
        QueryWrapper<User> phoneQueryWrapper = new QueryWrapper<>();
        phoneQueryWrapper.eq("phone", phone);
        User resultPhone = userMapper.selectOne(phoneQueryWrapper);
        // 判断查询结果是否不为null
        if (resultPhone != null) {
            // 是：找到了数据，表示手机号码已经被占用，则不允许注册，抛出PhoneDuplicateException
            throw new PhoneDuplicateException("注册失败！ 手机号已经被注册！");
        }
        // - 将手机号作为用户名
        user.setUsername(user.getPhone());
        // 如果代码能执行到这一行，则表示没有查到数据，表示用户名未被注册，则允许注册
        // 确保参数user中的数据全部是有效的
        // 取出参数user中的密码，调用私有的encode()方法进行加密，并将加密后的密码封装回到user中
        String rawPassword = user.getPassword();
        String encodedPassword = encode(rawPassword);
        user.setPassword(encodedPassword);
        // - createdTime：当前时间，LocalDateTime.now()
        user.setCreateTime(LocalDateTime.now());
        // - type：0，表示普通用户
        user.setType(0);
        // 日志
        log.debug("完善后的用户信息 > {}", user);
        // 调用userMapper.insert()执行插入数据，并获取返回的受影响行数
        int rows = userMapper.insert(user);
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 是：插入数据失败，则抛出InsertException
            throw new InsertException("注册失败！服务器忙，请稍后再次尝试！");
        }

        // 向“用户角色表”中插入数据，为当前用户账号分配角色
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(2); // 用户角色的id固定为2，具体可参见user_role数据表
        rows = userRoleMapper.insert(userRole);
        // 判断返回值（受影响的行数）是否不为1
        if (rows != 1) {
            // 是：受影响的行数不是1，则插入用户角色数据失败，抛出InsertException
            throw new InsertException("注册失败！服务器忙，请稍后再次尝试！");
        }
    }

    @Override
    public UserDetails login(String username) {
        // 根据参数username查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        // 判断查询结果是否为null，即：有没有这个用户
        // 注意：后续的验证和最终的界面是由Spring-Security显示的，此处不要抛出异常
        // 快捷键ifn
        if (user == null) {
            return null;
        }
        List<Permission> permissions = permissionMapper.selectByUserId(user.getId());
        String[] authorites = new String[permissions.size()];
        for (int i = 0; i < permissions.size(); i++) {
            authorites[i] = permissions.get(i).getName();
        }
        // 组织“用户详情”对象
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorites)
                .build();
        UserInfo userInfo = new UserInfo(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.isEnabled(),
                userDetails.isAccountNonExpired(),
                userDetails.isCredentialsNonExpired(),
                userDetails.isAccountNonLocked(),
                userDetails.getAuthorities()
        );
        userInfo.setId(user.getId());
        userInfo.setNickname(user.getNickname());
        userInfo.setType(user.getType());
        return userInfo;
    }

    private List<UserListVO> userList = new CopyOnWriteArrayList<>();

    @Override
    public List<UserListVO> getUserList() {
        if (userList.isEmpty()) {
            synchronized (CacheSchedule.LOCK_CACHE_QUESTION) {
                if (userList.isEmpty()) {
                    userList.addAll(userMapper.findUsers());
                }
            }
        }
        return userList;
    }

    @Override
    public List<UserListVO> getCachedUserList() {
        return userList;
    }

    /**
     * 执行密码加密
     *
     * @param rawPassword 原密码
     * @return 根据原密码执行加密得到的密文
     */
    private String encode(String rawPassword) {
        String encodePassword = passwordEncoder.encode(rawPassword);
        encodePassword = "{bcrypt}" + encodePassword;
        return encodePassword;
    }
}
