package com.example.demo;


import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication

public class DemospringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemospringbootApplication.class, args);

    }
}
