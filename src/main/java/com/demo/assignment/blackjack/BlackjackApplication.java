package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.constants.Constants;
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

        startGameForGeneralRandomScenario();

        startGameForBlackSCenario();
        startGameForRandomPackOfCards();
        startGameForPlayerWinScenario();
        startGameForDealerWinScenario();

    }

    /**
     * Change input in file InputFiles/main.txt to test your input.
     */
    private static void startGameForGeneralRandomScenario() {
        System.out.println("Here we are going to take Input from File `main.txt`");
        Result result = new Game().startGame("Sam", "classpath:inputFiles/main.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private static void startGameForBlackSCenario() {
        System.out.println("Here we are going to take Input from File `input_blackjack1.txt`");
        Result result = new Game().startGame("Sam", "classpath:inputFiles/input_blackjack1.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private static void startGameForRandomPackOfCards() {
        System.out.println("Here we are going to take full pack of 52 cards.");
        Result result = new Game().startGame("Karan", null);
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private static void startGameForPlayerWinScenario() {
        System.out.println("Here we are going to take Input from File `input_PlayerWinScenario1.txt`");
        Result result = new Game().startGame("Karan", "classpath:inputFiles/input_PlayerWinScenario1.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private static void startGameForDealerWinScenario() {
        System.out.println("Here we are going to take Input from File `input_DealerWinScenario1.txt`");
        Result result = new Game().startGame("Karan", "classpath:inputFiles/input_DealerWinScenario1.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

}
