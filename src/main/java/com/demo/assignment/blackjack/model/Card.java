package com.demo.assignment.blackjack.model;

import com.demo.assignment.blackjack.enums.Suit;
import com.demo.assignment.blackjack.enums.CardRank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {

    private CardRank rank;

    public Card(Card card) {
        this.rank = card.getRank();
    }

    public String toString() {
        return this.rank.name();
    }

}
