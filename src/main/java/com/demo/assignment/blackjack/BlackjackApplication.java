package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
		System.out.println("<<<<< Welcome to BlackJack >>>>>");
		Result result = new Game().startGame("Sam","classpath:inputFiles/input_blackjack1.txt");
		String summery = result.getSummery().get();
		System.out.println(summery);
		System.out.println(result.getMessage());
	}

}
