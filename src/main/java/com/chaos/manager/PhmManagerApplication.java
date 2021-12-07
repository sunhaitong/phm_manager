package com.chaos.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Slf4j
public class PhmManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PhmManagerApplication.class, args);
    }

}
