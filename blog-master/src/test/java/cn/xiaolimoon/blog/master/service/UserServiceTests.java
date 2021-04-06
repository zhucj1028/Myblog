package cn.xiaolimoon.blog.master.service;

import cn.xiaolimoon.blog.master.model.User;
import cn.xiaolimoon.blog.master.service.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class    UserServiceTests {

    @Autowired
    IUserService userService;

    @Test
    void registerUser() {
        try {
            User user = new User();
            user.setPhone("18388880001");
            user.setNickname("阿杰啊");
            user.setPassword("12345");
            userService.registerUser(user);
            log.debug("register student > OK.");
        } catch (ServiceException e) {
            log.debug("register student > failure.");
            log.debug("cause : {}", e.getClass());
        }
    }

    @Test
    void login() {
        String username = "18385244736";
        UserDetails userDetails = userService.login(username);
        log.debug("login, user details={}", userDetails);
    }

}

