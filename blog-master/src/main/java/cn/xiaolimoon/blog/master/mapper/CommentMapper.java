package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Comment;
import cn.xiaolimoon.blog.master.vo.CommentVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2021-01-09
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 根据博客的id查询评论的列表
     * @param articleId 博客的id
     * @return 该博客的所有评论的列表
     */
    List<CommentVO> findListByArticleId(Integer articleId);
}
