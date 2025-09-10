package com.enjoy.dubbo;

import com.enjoy.dubbo.consumer.HelloServiceConsumer;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class ConsumerBootStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        String res = context.getBean(HelloServiceConsumer.class).sayHello("dubbo");
        System.out.println(res);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.enjoy.dubbo.consumer")
    @PropertySource("classpath:consumer.properties")
    @ComponentScan(basePackages = {"com.enjoy.dubbo.consumer"})
    static class ConsumerConfiguration {
    }
}