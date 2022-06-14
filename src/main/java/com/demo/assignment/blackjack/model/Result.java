package com.demo.assignment.blackjack.model;

import com.demo.assignment.blackjack.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Supplier;

@Setter
@Getter
@AllArgsConstructor
public class Result {

    private String winner;
    private String message;
    private GameStatus status;
    private Supplier<String> summery;

}
