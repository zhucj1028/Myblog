package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqu
 * @since 2020-12-26
 */
@Repository
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 查询博客列表
     * @param question 博客表
     * @return  所有博客列表
     */
    List<QuestionVO> findQuestionList(Question question);

    /**
     * 根据博客id查询博客详情
     * @param id 博客的id
     * @return 匹配的博客详情，如果没有匹配的数据，则返回null
     */
    QuestionVO findById(Integer id);

    /**
     * @param id
     * @return
     */
    Question getCommentCount(Integer id);

}
