package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2020-12-11
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询某用户的权限
     * @param userId 用户的id
     * @return 该用户的权限的列表
     */
    List<Permission> selectByUserId(Integer userId);
}
