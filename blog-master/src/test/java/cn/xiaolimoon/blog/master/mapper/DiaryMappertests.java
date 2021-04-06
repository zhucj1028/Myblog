package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Diary;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class DiaryMappertests {
    @Autowired
    DiaryMapper mapper;

    @Test
    void selectById() {
        Integer id = 4;
        Diary diary = mapper.selectById(id);
        log.debug("Diary > {} ",diary);

    }

    @Test
    void deleteById() {
        Integer id = 4;
        int rows = mapper.deleteById(id);
        log.debug("delete ok, rows={}", rows);
    }

}

