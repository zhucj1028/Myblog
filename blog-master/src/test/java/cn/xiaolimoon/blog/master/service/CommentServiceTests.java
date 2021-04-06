package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.dto.CommentDTO;
import cn.xiaolimoon.blog.master.service.ex.ServiceException;
import cn.xiaolimoon.blog.master.vo.CommentVO;
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
public class CommentServiceTests {
    @Autowired
    ICommentService service;

    @Test
    void post() {
        try {
            CommentDTO commentDTO = new CommentDTO()
                    .setArticleId(56)
                    .setContent("HAHAHA!!!");
            Integer userId = 9;
            String userNickname = "小李";
            service.post(commentDTO, userId, userNickname);
            log.debug("OK");
        } catch (ServiceException e) {
            log.debug("failure >>> ", e);
        }
    }

    @Test
    void getListByQuestionId() {
        Integer articleId = 80;
        List<CommentVO> comments = service.getListByArticleId(articleId);
        for (CommentVO comment : comments) {
            log.debug("AnswerVO >>> {}", comment);
        }
    }

}
