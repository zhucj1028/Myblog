package cn.xiaolimoon.blog.master.controller;


import cn.xiaolimoon.blog.master.model.User;
import cn.xiaolimoon.blog.master.service.IUserService;
import cn.xiaolimoon.blog.master.service.ex.*;
import cn.xiaolimoon.blog.master.vo.R;
import cn.xiaolimoon.blog.master.vo.UserListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wuqu
 * @since 2020-12-09
 */
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    // localhost:8080/api/v1/users/register?nickname=Hello&phone=13800138008&password=12345
    @RequestMapping("/register")
    public R userRegister(
            @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult
                    .getFieldError().getDefaultMessage();
            log.debug("validation has error : {}", errorMessage);
            throw new ParameterValidationException(errorMessage);
        }
        userService.registerUser(user);
        return R.ok();
    }

    // http://localhost:8080/api/v1/users/userList
    @GetMapping("userList")
    public R<List<UserListVO>> userList() {
        return R.ok(userService.getUserList());
    }
}
