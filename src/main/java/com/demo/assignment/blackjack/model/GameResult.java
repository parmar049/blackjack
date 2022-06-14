package com.demo.assignment.blackjack.model;

import com.demo.assignment.blackjack.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GameResult {

    private String winner;
    private String message;
    private GameStatus status;

}
