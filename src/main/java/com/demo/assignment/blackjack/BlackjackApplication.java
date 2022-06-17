package com.demo.assignment.blackjack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BlackjackApplication {


    public static void main(String[] args) {
        SpringApplication.run(BlackjackApplication.class, args);
        System.out.println("<<<<< Welcome to BlackJack >>>>>");
    }

}
