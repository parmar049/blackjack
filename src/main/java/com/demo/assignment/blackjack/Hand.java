package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.model.Card;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<>();
    }
    public void takeCardFromDeck(CardDeck deck){
        hand.add(deck.takeCard());
    }

    public int calculateHandValue() {
        int value = 0;
        for(Card card: hand){
            value += card.getRank().getValue();
        }
        return value;
    }

    public Card getCard(int idx){
        return hand.get(idx);
    }


}
