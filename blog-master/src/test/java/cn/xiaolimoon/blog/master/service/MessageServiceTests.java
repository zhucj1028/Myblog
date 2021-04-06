package cn.xiaolimoon.blog.master.service;

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
public class MessageServiceTests {

    @Autowired
    IMessageService service;

   /* @Test
    void insertMessage() {
        Message message = new Message();
        message.setUserId(9);
        message.setUserNickname("小李");
        message.setContent("很不错啊");
        service.insertMessage(message);
        log.debug(" create > OK");
    }*/


}
