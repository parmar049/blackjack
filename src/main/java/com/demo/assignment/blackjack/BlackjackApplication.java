package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.model.CardDeck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
		System.out.println("Welcome to BlackJack !!");
		CardDeck playingCards = new CardDeck();
		playingCards.generateFullDeck();
		System.out.println(playingCards);

	}

}
