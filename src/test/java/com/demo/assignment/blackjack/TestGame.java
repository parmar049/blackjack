package com.demo.assignment.blackjack;

import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    void testFileReading() {
        Game game = new Game();
        String data = game.readInput("classpath:input1.txt");
    }
}
