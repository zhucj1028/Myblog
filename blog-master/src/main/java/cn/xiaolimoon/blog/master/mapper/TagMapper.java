package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.vo.TagVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2020-12-17
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 查询所有标签数据
     * @return 所有标签数据的列表
     */
    List<TagVO> findAll();




}
