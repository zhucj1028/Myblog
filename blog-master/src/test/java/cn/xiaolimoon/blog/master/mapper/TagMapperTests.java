package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Tag;
import cn.xiaolimoon.blog.master.vo.TagVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class TagMapperTests {

    @Autowired
    TagMapper mapper;

    @Test
    void insertTag() {
        Tag tag = new Tag();
        tag.setName("Mybatis");
        tag.setCreateTime(LocalDateTime.now());
        int rows = mapper.insert(tag);
        log.debug("rows >>> {} ",rows);
    }

    @Test
    void tag() {
        List<TagVO> tags = mapper.findAll();
        log.debug("tags count = {}", tags.size());
        for (TagVO tag : tags) {
            log.debug(">>> tag : {}", tag);
        }
    }
}
