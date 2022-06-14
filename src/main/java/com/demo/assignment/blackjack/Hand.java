package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.model.Card;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Hand {

    private ArrayList<Card> hand;
    private StringBuilder handToPrint;

    public Hand(){
        this.hand = new ArrayList<>();
        this.handToPrint = new StringBuilder("");
    }
    public void takeCardFromDeck(CardDeck deck){
        hand.add(deck.takeCard());
        handToPrint.append(hand.get(hand.size()-1)).append(", ");
    }

    public int calculateHandValue() {
        int value = 0;
        for(Card card: hand){
            value += card.getRank().getValue();
        }
        return value;
    }

}
