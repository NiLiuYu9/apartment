package com.n.lease;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.n.lease.web.*.mapper")
@SpringBootApplication
public class AppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class, args);
    }
}
