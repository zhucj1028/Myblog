package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Message;
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
public class MessageMapperTests {

    @Autowired
    MessageMapper messageMapper;

    @Test
    void insert() {
        Message message = new Message();
        message.setId(1);
        message.setUserId(9);
        message.setUserNickname("小李");
        message.setContent("不错哦");
        message.setCreateTime(LocalDateTime.now());
        int rows = messageMapper.insert(message);
        log.debug(" message > {} ", rows);

    }

    @Test
    void selectById() {
        Integer id = 1;
        Message message = messageMapper.selectById(id);
        log.debug("message > {}", message);
    }

}
