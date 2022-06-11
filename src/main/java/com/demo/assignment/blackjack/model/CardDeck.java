package com.demo.assignment.blackjack.model;

import com.demo.assignment.blackjack.enums.Suit;
import com.demo.assignment.blackjack.enums.Value;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private List<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    public void generateFullDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public String toString() {
        StringBuilder cardList = new StringBuilder("");
        int counter = 0;
        for (Card card : this.cards) {
            cardList.append("\n").append(counter).append("-").append(card.toString());
            counter++;
        }
        return cardList.toString();
    }
}
