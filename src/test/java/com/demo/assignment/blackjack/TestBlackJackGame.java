package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.Service.BlackJack;
import com.demo.assignment.blackjack.Service.BlackJackImpl;
import com.demo.assignment.blackjack.constants.Constants;
import com.demo.assignment.blackjack.enums.GameStatus;
import com.demo.assignment.blackjack.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBlackJackGame {

    private BlackJack blackJack;

    @BeforeAll
    void setUp(){
        blackJack = new BlackJackImpl();
    }

    @Test
    void testBlackJackScenario() {
        /**
         *  When Player has blackJack
         */
        Result gameResult1 = blackJack.getWinner("Karan", "classpath:inputFiles/input_blackjack1.txt");
        Assertions.assertEquals("Karan", gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());
        /**
         *  When Dealer has blackJack
         */
        Result gameResult2 = blackJack.getWinner("Karan", "classpath:inputFiles/input_blackjack2.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult2.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());
    }

    @Test
    void testDoubleAceScenario() {
        /**
         *  When Both player has double ace then Dealer should be winner
         */
        Result gameResult1 = blackJack.getWinner("Karan", "classpath:inputFiles/input_DoubleAce.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());
    }

    @Test
    void testPlayerWinScenario() {
        /**
         *  Scenario 1 ----------- >
         */
        Result gameResult1 = blackJack.getWinner("Karan", "classpath:inputFiles/input_PlayerWinScenario1.txt");
        Assertions.assertEquals("Karan", gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());

        /**
         *  Scenario 2 ----------- >
         */
        Result gameResult2 = blackJack.getWinner("Karan", "classpath:inputFiles/input_PlayerWinScenario2.txt");
        Assertions.assertEquals("Karan", gameResult2.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult2.getStatus());

    }

    @Test
    void testDealerWinScenario() {
        /**
         *  Scenario 1 ----------- >
         */
        Result gameResult1 = blackJack.getWinner("Karan", "classpath:inputFiles/input_DealerWinScenario1.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult1.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult1.getStatus());

        /**
         *  Scenario 2 ----------- >
         */
        Result gameResult2 = blackJack.getWinner("Karan", "classpath:inputFiles/input_DealerWinScenario2.txt");
        Assertions.assertEquals(Constants.DEALER_NAME, gameResult2.getWinner());
        Assertions.assertEquals(GameStatus.FINISHED, gameResult2.getStatus());

    }

}
