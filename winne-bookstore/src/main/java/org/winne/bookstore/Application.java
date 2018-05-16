package org.winne.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.winne.base.GlobalExceptionHandler;

@MapperScan("org.winne.bookstore.dao")
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public GlobalExceptionHandler exceptionHandler() {
        return new GlobalExceptionHandler();
    }
}