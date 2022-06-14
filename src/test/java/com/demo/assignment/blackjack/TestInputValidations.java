package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.constants.Constants;
import com.demo.assignment.blackjack.enums.GameStatus;
import com.demo.assignment.blackjack.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInputValidations {

    @Test
    void testFileReading() {
        Game game = new Game();
        String data = game.readInput("classpath:inputFiles/InvalidInput.txt");
        Assertions.assertNotNull(data);
    }

    /**
     * If there is invalid input which is irrelevent then it should throw exception
     */
    @Test
    void testInvalidInput() {
        Game game = new Game();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.startGame("Karan", "classpath:inputFiles/InvalidInput.txt");
        });
    }

    /**
     * All input cards should be unique.
     */
    @Test
    void testDuplicateCardInput() {
        Game game = new Game();
        Result gameResult1 = game.startGame("Karan", "classpath:inputFiles/Input_DuplicateCard.txt");
        Assertions.assertEquals(GameStatus.TERMINATED, gameResult1.getStatus());
        Assertions.assertTrue(gameResult1.getMessage().contains(Constants.INVALID_INPUT_MSG));
    }
}
