package com.vmms.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("UserMapper")
class VmmsApplicationTests {

    @Test
    void contextLoads() {
    }

}
