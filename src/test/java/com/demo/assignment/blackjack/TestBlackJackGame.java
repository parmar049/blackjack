package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.constants.Constants;
import com.demo.assignment.blackjack.enums.GameStatus;
import com.demo.assignment.blackjack.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBlackJackGame {

    @Test
    void testBlackJackScenario() {
        Game game = new Game();
        /**
         *  When Player has blackJack
         */
        Result gameResult1 = game.startGame("Karan", "classpath:inputFiles/input_blackjack1.txt");
        Assertions.assertEquals("Karan", gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());
        /**
         *  When Dealer has blackJack
         */
        Result gameResult2 = game.startGame("Karan", "classpath:inputFiles/input_blackjack2.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult2.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());
    }

    @Test
    void testDoubleAceScenario() {
        Game game = new Game();
        /**
         *  When Both player has double ace then Dealer should be winner
         */
        Result gameResult1 = game.startGame("Karan", "classpath:inputFiles/input_DoubleAce.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());
    }

    @Test
    void testPlayerWinScenario() {
        Game game = new Game();

        /**
         *  Scenario 1 ----------- >
         */
        Result gameResult1 = game.startGame("Karan", "classpath:inputFiles/input_PlayerWinScenario1.txt");
        Assertions.assertEquals("Karan", gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());

        /**
         *  Scenario 2 ----------- >
         */
        Result gameResult2 = game.startGame("Karan", "classpath:inputFiles/input_PlayerWinScenario2.txt");
        Assertions.assertEquals("Karan", gameResult2.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult2.getStatus());

    }

    @Test
    void testDealerWinScenario() {
        Game game = new Game();

        /**
         *  Scenario 1 ----------- >
         */
        Result gameResult1 = game.startGame("Karan", "classpath:inputFiles/input_DealerWinScenario1.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());

        /**
         *  Scenario 2 ----------- >
         */
        Result gameResult2 = game.startGame("Karan", "classpath:inputFiles/input_DealerWinScenario2.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult2.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult2.getStatus());

    }

}
