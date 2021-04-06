package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.vo.LinkVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2021-01-03
 */
@Repository
public interface LinkMapper extends BaseMapper<Link> {

    /**
     * 查询所有链接
     * @return 链接列表
     */
    List<LinkVO> findLinkAll();
}
