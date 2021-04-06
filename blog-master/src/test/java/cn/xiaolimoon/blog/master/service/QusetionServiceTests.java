package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.dto.QuestionDTO;
import cn.xiaolimoon.blog.master.service.ex.ServiceException;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class QusetionServiceTests {
    @Autowired
    IQuestionService questionService;

    @Test
    void create() {
        try {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setTagIds(new Integer[]{1,2});
            Integer userId = 9;
            String userNickname = "小李";
            questionDTO.setTitle("你学会了吗");
            questionDTO.setContent("我已经学废了！");
            questionService.create(questionDTO, userId, userNickname);
            log.debug("create question ok.");
        } catch (ServiceException e) {
            log.debug("create question failure.", e);
        }
    }

    @Test
    void getQuestiuonById() {
        Integer id = 56;
        QuestionVO questionVO = questionService.getQuestionById(id);
        log.debug("question >>> {}", questionVO);
    }


    /*@Test
    void getQuestionsByUserId() {
        Integer userId = 9;
        List<QuestionVO> questions = questionService.getQuestionsByUserId(userId);
        log.debug("question count = {}", questions.size());
        for (QuestionVO question : questions) {
            log.debug(">>> {}", question);
        }
    }*/

    @Test
    void getQuestionsByUser() {
        Integer userId = 9;
        Integer page = 1;
       // PageInfo<QuestionVO> pageInfo = questionService.getQuestions(page,userId);
        // log.debug("page info >>> {}", pageInfo);
    }


}
