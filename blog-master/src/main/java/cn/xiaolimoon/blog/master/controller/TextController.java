package cn.xiaolimoon.blog.master.controller;

import cn.xiaolimoon.blog.master.model.User;
import cn.xiaolimoon.blog.master.security.UserInfo;
import cn.xiaolimoon.blog.master.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

/**
 * @author Zcj
 */
@RestController
@RequestMapping("/test")
public class TextController {

    @Autowired
    private IUserService userService;

    @GetMapping("user/{id}")
    @PreAuthorize("hasAuthority('test:user:info')")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    // http://localhost:8080/test/user/current/authentication
    @GetMapping("/user/current/authentication")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }

    // http://localhost:8080/test/user/current/principal
    @GetMapping("/user/current/principal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    // http://localhost:8080/test/user/current/details
    @GetMapping("/user/current/details")
    public UserDetails getUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    // http://localhost:8080/test/user/current/info
    @GetMapping("/user/current/info")
    public UserInfo getUserInfo(@AuthenticationPrincipal UserInfo userInfo) {
        System.out.println("user id = " + userInfo.getId());
        System.out.println("user nickname = " + userInfo.getNickname());
        return userInfo;
    }

}
