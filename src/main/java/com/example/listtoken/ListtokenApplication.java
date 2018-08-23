package com.example.listtoken;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Huoshan
 */
@SpringBootApplication
@MapperScan("com.example.*.dao")
public class ListtokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListtokenApplication.class, args);
    }
}
