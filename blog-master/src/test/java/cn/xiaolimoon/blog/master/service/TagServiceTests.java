package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class TagServiceTests {

    @Autowired
    ITagService tagService;

    @Test
    void insertTag() {
        Tag tag = new Tag();
        tag.setName("MybatisPlus");
        tagService.insertTag(tag);
        log.debug("create tag > OK.");
    }
}
