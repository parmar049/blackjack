package com.demo.assignment.blackjack.controller;

import com.demo.assignment.blackjack.Service.BlackJack;
import com.demo.assignment.blackjack.constants.Constants;
import com.demo.assignment.blackjack.model.Result;
import org.springframework.stereotype.Controller;


@Controller
public class GameController {

    private BlackJack blackJack;

    public GameController(BlackJack blackJack){
        this.blackJack = blackJack;
        startGameForGeneralRandomScenario();
        startGameForBlackSCenario();
        startGameForRandomPackOfCards();
        startGameForPlayerWinScenario();
        startGameForDealerWinScenario();
    }
    /**
     * Change input in file InputFiles/main.txt to test your input.
     */
    private void startGameForGeneralRandomScenario() {
        System.out.println("Here we are going to take Input from File `main.txt`");
        Result result = blackJack.getWinner("Sam", "classpath:inputFiles/main.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private void startGameForBlackSCenario() {
        System.out.println("Here we are going to take Input from File `input_blackjack1.txt`");
        Result result = blackJack.getWinner("Sam", "classpath:inputFiles/input_blackjack1.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private void startGameForRandomPackOfCards() {
        System.out.println("Here we are going to take full pack of 52 cards.");
        Result result = blackJack.getWinner("Karan", null);
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private void startGameForPlayerWinScenario() {
        System.out.println("Here we are going to take Input from File `input_PlayerWinScenario1.txt`");
        Result result = blackJack.getWinner("Karan", "classpath:inputFiles/input_PlayerWinScenario1.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }

    private  void startGameForDealerWinScenario() {
        System.out.println("Here we are going to take Input from File `input_DealerWinScenario1.txt`");
        Result result = blackJack.getWinner("Karan", "classpath:inputFiles/input_DealerWinScenario1.txt");
        String summary = result.getSummary().get();
        System.out.println(summary);
        System.out.println(result.getMessage());
        System.out.println(Constants.LINE_SEPARATOR);
    }
}
