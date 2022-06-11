package com.demo.assignment.blackjack.model;

import com.demo.assignment.blackjack.enums.Suit;
import com.demo.assignment.blackjack.enums.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {

    private List<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    public void generateCardDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffleDeck() {
        List<Card> tempDeck = new ArrayList<>();
        while (this.cards.size() > 0) {
            int index = (int) (Math.random() * cards.size());
            Card removedCard = cards.remove(index);
            tempDeck.add(removedCard);
        }
        this.cards = tempDeck;
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
