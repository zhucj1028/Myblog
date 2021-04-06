package cn.xiaolimoon.blog.master.mapper;

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
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void findUser() {
        List<UserListVO> userList= userMapper.findUsers();
        log.debug("userList", userList.size());
        for (UserListVO user : userList) {
            log.debug(">>> {}",user);
        }
    }

}
