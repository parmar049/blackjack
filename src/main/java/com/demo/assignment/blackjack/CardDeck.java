package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.enums.Suit;
import com.demo.assignment.blackjack.enums.CardRank;
import com.demo.assignment.blackjack.exception.InvalidInputException;
import com.demo.assignment.blackjack.model.Card;
import lombok.Getter;

import java.util.*;

@Getter
public class CardDeck {

    private List<Card> deck;

    public CardDeck() {
        this.deck = new ArrayList<>();
    }

    public void generateCardDeck() {
        for (CardRank cardValue : CardRank.values()) {
            this.deck.add(new Card(cardValue));
        }
    }

    public void generateCardDeck(Set<CardRank> cards) {
        for (CardRank card : cards) {
            this.deck.add(new Card(card));
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard() {
        //Take a copy of the first card from the deck
        Card cardToTake = new Card(deck.get(0));
        //Remove the card from the deck. Index is hardcoded to 0 as we remove the element so next element will be now
        //on 0th position
        deck.remove(0);
        return cardToTake;

    }

    public String toString() {
        StringBuilder cardList = new StringBuilder("");
        int counter = 0;
        for (Card card : this.deck) {
            cardList.append("\n").append(counter).append("-").append(card.toString());
            counter++;
        }
        return cardList.toString();
    }

    public Set<CardRank> validateCardInput(String[] cards) throws InvalidInputException {
        Set<CardRank> setOfCards = new LinkedHashSet<>();
        for (String card : cards) {
            setOfCards.add(CardRank.valueOf(card.trim()));
        }
        if (cards.length != setOfCards.size()) {
            throw new InvalidInputException("Invalid input. There might be a duplicate card in the input string");
        }

        return setOfCards;
    }
}
