package dev.be.feign.fegin.config;

import dev.be.feign.fegin.decoder.DemoFeignErrorDecoder;
import dev.be.feign.interceptor.DemoFeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFeignConfig {

    @Bean
    public DemoFeignInterceptor feignInterceptor() {
        return DemoFeignInterceptor.of();
    }

    @Bean
    public DemoFeignErrorDecoder demoErrorDecoder() {
        return new DemoFeignErrorDecoder();
    }
}
