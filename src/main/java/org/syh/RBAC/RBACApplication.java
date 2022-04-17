package org.syh.RBAC;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.syh.RBAC.mapper")
public class RBACApplication {
    public static void main(String[] args) {
        SpringApplication.run(RBACApplication.class,args);
    }
}
