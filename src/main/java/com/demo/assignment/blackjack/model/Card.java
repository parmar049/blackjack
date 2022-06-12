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
    private Suit suit;
    private CardRank rank;

    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    public String toString() {
        return this.suit.toString().concat("-").concat(rank.toString().concat("-").concat(String.valueOf(rank.getValue())));
    }

}
