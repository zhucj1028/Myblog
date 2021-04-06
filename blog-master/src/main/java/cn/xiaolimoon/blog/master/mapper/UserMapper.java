package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.model.User;
import cn.xiaolimoon.blog.master.vo.UserListVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2020-12-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查找用户数据
     * @return 用户列表
     */
    List<UserListVO> findUsers();

}
