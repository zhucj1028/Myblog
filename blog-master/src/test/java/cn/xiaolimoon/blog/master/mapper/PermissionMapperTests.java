package cn.xiaolimoon.blog.master.mapper;

import cn.xiaolimoon.blog.master.model.Permission;
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
public class PermissionMapperTests {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    void selectByUserId() {
        Integer userId = 9;
        List<Permission> permissions = permissionMapper.selectByUserId(userId);
        log.debug("permissions count={}", permissions.size());
        for (Permission permission : permissions) {
            log.debug("permission > {}", permission);
        }
    }
}
