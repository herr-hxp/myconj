package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

@RestController
class HelloWorldController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/testdb")
    public String testDbConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "Database Connection OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "Database Connection FAILED";
        }
    }
}

