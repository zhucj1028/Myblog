package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Diary;
import cn.xiaolimoon.blog.master.service.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class DiaryServiceTests {
    @Autowired
    IDiaryService diaryService;

    @Test
    void insertDiary() {
        Diary diary = new Diary();
        diary.setUserId(9);
        diary.setContent("今天你在做什么呢");
        diary.setCreateTime(LocalDateTime.now());
        diaryService.insertDiary(diary);
        log.debug("create diary > OK");
    }

    @Test
    void delete() {
        try {
            Integer diaryId = 3;
            Diary diary = diaryService.deleteDiary(diaryId);
            log.debug("OK, comment >>> {}", diary);
        } catch (ServiceException e) {
            log.debug("【删除评论失败】");
            log.debug("错误类型：{}", e.getClass().getName());
            log.debug("错误原因：{}", e.getMessage());
        }
    }
}
