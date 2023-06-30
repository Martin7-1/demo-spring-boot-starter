package com.zyinnju;

import com.zyinnju.service.DemoService;
import com.zyinnju.service.SampleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SampleServiceTest {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    SampleService sampleService;

    @Test
    void testBeanExist() {
        // 能够获取到 DemoService 类型的 bean，不抛出异常
        Assertions.assertDoesNotThrow(() -> applicationContext.getBean(DemoService.class));
    }

    @Test
    void testHello() {
        Assertions.assertEquals("hello", sampleService.hello());
    }
}
