package com.demo.assignment.blackjack;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private Hand hand;
    private String name;

    public Person(String name) {
        // Whenever a new player comes to play give them a new hand a name
        this.hand = new Hand();
        this.name = name;
    }

    public boolean hasBlackjack() {
        return this.getHand().calculateHandValue() == 21 ? true : false;
    }

    public boolean hasBothAceInHand() {
        return this.getHand().calculateHandValue() == 22 ? true : false;
    }

}
