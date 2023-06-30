package com.zyinnju;

import com.zyinnju.service.DemoService;
import com.zyinnju.service.impl.DemoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * auto configuration for demo service
 *
 * <p>使用 demo.enabled 来开启该配置</p>
 *
 * @author zhengyi 32
 */
@AutoConfiguration
@ConditionalOnProperty(value = "demo.enabled")
public class DemoServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DemoService demoService() {
        return new DemoServiceImpl();
    }
}
