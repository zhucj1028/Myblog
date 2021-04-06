package cn.xiaolimoon.blog.master.mapper;

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
public class CommentMapperTests {

    @Autowired
    CommentMapper mapper;

    @Test
    void findListByArticleId() {
        Integer articleId = 80;
        List<CommentVO> comments = mapper.findListByArticleId(articleId);
        for (CommentVO comment : comments) {
            log.debug("AnswerVO >>> {}", comment);
        }
    }

}
