package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.model.GameResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    void testFileReading() {
        Game game = new Game();
        String data = game.readInput("classpath:input1.txt");
    }

    void testInvalidInput() {
        Game game = new Game();
        GameResult gameResult = game.startGame("Karan", "classpath:inputFiles/input_blackjack1.txt");

    }

    /**
     *  When Player has blackJack
     */
    @Test
    void testBlackJackScenario() {
        Game game = new Game();
        GameResult gameResult1 = game.startGame("Karan", "classpath:inputFiles/input_blackjack1.txt");
        Assertions.assertEquals("Karan", gameResult1.getWinner());

        GameResult gameResult2 = game.startGame("Karan", "classpath:inputFiles/input_blackjack2.txt");
        Assertions.assertEquals("Dealer", gameResult2.getWinner());

    }


}
