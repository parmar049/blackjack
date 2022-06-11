package com.demo.assignment.blackjack.model;

import com.demo.assignment.blackjack.enums.Suit;
import com.demo.assignment.blackjack.enums.Value;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private Suit suit;
    private Value value;

    public String toString() {
        return this.suit.toString().concat("-").concat(value.toString());
    }

}
