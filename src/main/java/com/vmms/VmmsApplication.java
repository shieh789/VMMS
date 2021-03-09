package com.vmms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vmms.*.dao")
public class VmmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VmmsApplication.class, args);
    }

}
