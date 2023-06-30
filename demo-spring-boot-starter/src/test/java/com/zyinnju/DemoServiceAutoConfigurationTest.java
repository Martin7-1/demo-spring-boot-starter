package com.zyinnju;

import com.zyinnju.service.DemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * @author zhengyi
 */
class DemoServiceAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(DemoServiceAutoConfiguration.class));

    @Test
    void testBeanExist() {
        // 测试在有 demo.enabled=true 的情况下是否有 DemoService 的 Bean
        contextRunner.withInitializer(new ConditionEvaluationReportLoggingListener(LogLevel.INFO))
                .withPropertyValues("demo.enabled=true").run(context -> Assertions.assertDoesNotThrow(() -> context.getBean(DemoService.class)));
        // 测试在有 demo.enabled=false 的情况下是否有 DemoService 的 Bean
        contextRunner.withInitializer(new ConditionEvaluationReportLoggingListener(LogLevel.INFO))
                .withPropertyValues("demo.enabled=false").run(context -> Assertions.assertThrows(BeansException.class, () -> context.getBean(DemoService.class)));
    }
}
