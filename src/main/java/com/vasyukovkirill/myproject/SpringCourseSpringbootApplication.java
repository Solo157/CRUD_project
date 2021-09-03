package com.vasyukovkirill.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringCourseSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCourseSpringbootApplication.class, args);
    }

}
