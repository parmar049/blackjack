package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.Service.BlackJack;
import com.demo.assignment.blackjack.Service.BlackJackImpl;
import com.demo.assignment.blackjack.constants.Constants;
import com.demo.assignment.blackjack.enums.GameStatus;
import com.demo.assignment.blackjack.model.Result;
import com.demo.assignment.blackjack.util.BlackJackUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInputValidations {

    private BlackJack blackJack;

    @BeforeAll
    void setUp(){
        blackJack = new BlackJackImpl();
    }

    @Test
    void testFileReading() {
        String data = BlackJackUtil.readInput("classpath:inputFiles/InvalidInput.txt");
        Assertions.assertNotNull(data);
    }

    /**
     * If there is invalid input which is irrelevent then it should throw exception
     */
    @Test
    void testInvalidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            blackJack.getWinner("Karan", "classpath:inputFiles/InvalidInput.txt");
        });
    }

    /**
     * All input cards should be unique.
     */
    @Test
    void testDuplicateCardInput() {
        Result gameResult1 = blackJack.getWinner("Karan", "classpath:inputFiles/Input_DuplicateCard.txt");
        Assertions.assertEquals(GameStatus.TERMINATED, gameResult1.getStatus());
        Assertions.assertTrue(gameResult1.getMessage().contains(Constants.INVALID_INPUT_MSG));
    }
}
