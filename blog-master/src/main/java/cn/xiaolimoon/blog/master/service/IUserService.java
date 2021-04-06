package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.User;
import cn.xiaolimoon.blog.master.vo.UserListVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 * 开发顺序应该是：持久层 --> 业务层 --> 控制器层 --> 用户界面。
 * @author wuqu
 * @since 2020-12-09
 */
public interface IUserService extends IService<User> {

    /**
     * 用户注册
     * @param user 用户列表
     */
    void registerUser(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @return
     */
    UserDetails login(String username);

    /**
     * 显示用户列表
     * @return 用户列表
     */
    List<UserListVO> getUserList();

    /**
     * 当缓存被清空后，可能获取到空的列表
     * @return 用户缓存列表
     */
    List<UserListVO> getCachedUserList();

}
