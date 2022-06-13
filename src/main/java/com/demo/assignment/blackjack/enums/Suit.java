package com.demo.assignment.blackjack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Suit {
    C("CLUB"),
    D("DIAMOND"),
    S("SPADE"),
    H("HEART");

    private final String label;

}
