package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("UserMapper")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
