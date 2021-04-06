package cn.xiaolimoon.blog.master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xiaolimoon.blog.master.mapper")
public class BlogMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogMasterApplication.class, args);
    }

}
