package com.demo.assignment.blackjack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GameResult {

    private String winner;
    private String message;

}
