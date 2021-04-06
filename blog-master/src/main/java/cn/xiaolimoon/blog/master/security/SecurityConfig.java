package cn.xiaolimoon.blog.master.security;

import cn.xiaolimoon.blog.master.mapper.QuestionMapper;
import cn.xiaolimoon.blog.master.model.Question;
import cn.xiaolimoon.blog.master.service.IQuestionService;
import cn.xiaolimoon.blog.master.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.yaml.snakeyaml.events.Event;

/**
 * @author Zcj
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录页面的URL
        String loginPageUrl = "/login.html";
        // 处理登录请求的URL
        String loginProcessingUrl = "/login";
        // 登录失败后的URL
        String loginFailureUrl = "/login.html?error";
        // 登录成功后的URL
        String loginSuccessUrl = "/index.html";
        // 退出登录的URL
        String logoutUrl = "/logout";
        // 退出登录成功后的URL
        String logoutSuccessUrl = "/login.html?logout";
        // 准备白名单，是不需要登录就可以访问的路径
        String[] antMatchers = {
                loginPageUrl,
                "/login.html",
                "/index.html",
                "/register.html",
                "/my.html",
                "/link.html",
                "/read.html",
                "/diary.html",
                "/article.html",
                "/message.html",

                "/api/v1/diary",
                "/api/v1/links",
                "/api/v1/message",
                "/api/v1/comment",
                "/api/v1/questions",
                "/api/v1/questions/my",
                "/api/v1/message/create",
                "/api/v1/users/register",

                "/assets/**",
                "/css/**",
                "/font/**",
                "/font-awesome/**",
                "/image/**",
                "/js/**",
                "/layui/**",
                "/vue/**"
        };

        /*
         * 授权设置，是相对固定的配置
         * csrf().disable() > 关闭跨域攻击
         * authorizeRequests() > 对请求进行授权
         * antMatchers() > 配置访问白名单
         * permitAll() > 对白名单中的路径进行授权
         * anyRequest() > 其它的请求
         * authenticated() > 仅经过授权的允许访问，也可以理解为“未被授权将不允许访问”
         * and.formLogin() > 未被授权的将通过登录表单进行验证登录并授权
         **/
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(antMatchers).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage(loginPageUrl)
                .loginProcessingUrl(loginProcessingUrl)
                .failureUrl(loginFailureUrl)
                .defaultSuccessUrl(loginSuccessUrl)
                .and().logout()
                .logoutUrl(logoutUrl)
                .logoutSuccessUrl(logoutSuccessUrl);
    }


}
