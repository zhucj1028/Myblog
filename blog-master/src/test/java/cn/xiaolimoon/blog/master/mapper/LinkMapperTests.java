package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Link;
import cn.xiaolimoon.blog.master.vo.LinkVO;
import cn.xiaolimoon.blog.master.vo.UserListVO;
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
public class LinkMapperTests {
    @Autowired
    LinkMapper mapper;

    @Test
    void insert() {
        Link link = new Link();
        link.setName("百度");
        link.setUrl("www.baidu.com");
        mapper.insert(link);
        log.debug("create linl > OK.");
    }

    @Test
    void selectById() {
        Integer id = 1;
        Link link = mapper.selectById(id);
        log.debug("linK > {}",link);
    }

    @Test
    void findLinkAll() {
        List<LinkVO> userList= mapper.findLinkAll();
        log.debug("userList", userList.size());
        for (LinkVO linkVO : userList) {
            log.debug(">>> {}",linkVO);
        }
    }


}
