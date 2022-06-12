package com.demo.assignment.blackjack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CardRank {
    TWO("TWO", 2), THREE("THREE", 3), FOUR("FOUR", 4), FIVE("FIVE", 5),
    SIX("SIX", 6), SEVEN("SEVEN", 7), EIGHT("EIGHT", 8), NINE("NINE", 9),
    TEN("TEN", 10), JACK("JACK", 10), QUEEN("QUEEN", 10), KING("KING", 10),
    ACE("ACE", 11);

    private final String name;
    private final int value;

}


