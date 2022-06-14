package com.demo.assignment.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
		System.out.println("Welcome to BlackJack !!");
		new Game().startGame("Sam","classpath:input1.txt");
	}

}
