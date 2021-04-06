package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.Link;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class LinkServiceTests {
    @Autowired
    ILinkService linkService;

    @Test
    void insertLink() {
        Link link = new Link();
        link.setName("阿里云");
        link.setUrl("www.aliyun.com");
        link.setDescription("阿里云服务器,网站搭建");
        linkService.insertLink(link);
        log.debug("create link >>> OK.");
    }


}
