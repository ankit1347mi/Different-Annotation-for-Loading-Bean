package com.tyss.differentconditionalannotaions.config;

import com.tyss.differentconditionalannotaions.dto.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
public class MyConfiguration {

    @Bean
    @Profile("dev")
    public MyBean devBean() {
        return new MyBean("Dev Bean");
    }

    @Bean
    @Profile("prod")
    public MyBean prodBean() {
        return new MyBean("Prod Bean");
    }

    @Bean
    @ConditionalOnProperty(name = "myapp.feature.enabled", havingValue = "true")
    public MyBean conditionalPropertyBean() {
        System.out.println("Conditional Property Bean");
        return new MyBean("Conditional Property Bean");
    }

    @Bean
    @ConditionalOnClass(name = "com.tyss.differentconditionalannotaions.dto.MyBean")
    public MyBean conditionalClassBean() {
        System.out.println("Conditional Class Bean");
        return new MyBean("Conditional Class Bean");
    }


    @Bean
    @ConditionalOnMissingBean
    public MyBean missingBean() {
        System.out.println("Missing Bean");
        return new MyBean("Missing Bean");
    }
}
