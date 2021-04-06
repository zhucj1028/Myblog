package cn.xiaolimoon.blog.master.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Zcj
 */
@SpringBootTest
@Slf4j
public class SecurityTests {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void encode() {
        String rawPassword = "123456";
        String encodePassword = passwordEncoder.encode(rawPassword);
        log.debug("raw password={}, encode password={}", rawPassword, encodePassword);
    }
}

