package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
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
public class QuestionMapperTests {
    @Autowired
    QuestionMapper questionMapper;

    @Test
    void findListByUserId() {
        Question question = new Question();
        List<QuestionVO> questions = questionMapper.findQuestionList(question);
        log.debug("question count={}", questions.size());
        for (QuestionVO q : questions) {
            log.debug(">>> {}",question);
        }
    }

    @Test
    void findById() {
        Integer id = 56;
        QuestionVO questionVO = questionMapper.findById(id);
        log.debug("question >>> {}", questionVO);
    }

}
