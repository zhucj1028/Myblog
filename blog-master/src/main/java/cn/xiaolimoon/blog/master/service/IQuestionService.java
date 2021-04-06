package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.dto.QuestionDTO;
import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuqu
 * @since 2020-12-26
 */
public interface IQuestionService extends IService<Question> {


    /**
     * @param questionDTO
     * @param userId
     * @param userNickname
     */
    void create(QuestionDTO questionDTO, Integer userId, String userNickname);


    /**
     * @param question
     * @param page
     * @return
     */
    PageInfo<QuestionVO> getQuestions(Question question,Integer page);

    /**
     * 根据博客的id查找博客详情
     *
     * @param id 博客的id
     * @return 匹配的博客的详情
     */
    QuestionVO getQuestionById(Integer id);

    /**
     * 删除博客
     * @param id 博客数据id
     * @return 成功删除的数据
     */
    Question deleteQuestion(Integer id);

}
