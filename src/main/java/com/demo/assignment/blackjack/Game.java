package com.demo.assignment.blackjack;

import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Game {

    /**
     * This game is designed to play just one round. It can be modified a bit to play multiple rounds with multiple players
     */
    public void startGame() {
        System.out.println("Starting first Round...");
        String fileContent = readInput("classpath:input1.txt");
        CardDeck cardDeck = null;
        if (ObjectUtils.isEmpty(fileContent)) {
            System.out.println("Didn't find any input parameters so initializing random deck of 52 cards");
            cardDeck = new CardDeck();
            cardDeck.generateCardDeck();
            cardDeck.shuffleDeck();
            System.out.println(cardDeck);
        } else {
            // Code to convert readfile in Deck Object
        }

        Person dealer = new Person("Dealer");
        Person player = new Person("Sam");

        for (int counter = 0; counter < cardDeck.getDeck().size() - 1; counter++) {
            /*
             * For first 2 hands needs to be drawn for both player and dealer
             */
            if (player.getHand().calculateHandValue() < 17) {
                player.getHand().takeCardFromDeck(cardDeck);
            }
            dealer.getHand().takeCardFromDeck(cardDeck);
            player.printHand(counter);
            dealer.printHand(counter);

            if (counter < 1) {
                continue;//Back to loop to draw one more card for both player and dealer.
            }

            /**
             * We just need to check during first hand
             * It doesn't matter if dealer also have a blackjack, if Player has a blackjack he is winner
             */
            if (counter == 1 && player.hasBlackjack()) {
                System.out.println(player.getName().concat(" has blackjack so he is a winner "));
                System.out.println("Winner :: " + player.getName());
                break;
            }
            /**
             * We just need to check during first hand
             * If Player has both card ACE then score is >21 so he lost, doesn't matter if dealer also has both ACE
             */
            if (counter == 1 && player.hasBothAceInHand()) {
                System.out.println(player.getName().concat(" has score of 22 so he lost the game."));
                System.out.println("Winner :: " + dealer.getName());
                break;
            }

            if (player.getHand().calculateHandValue() > 21) {
                System.out.println(player.getName().concat(" has score greater than 21 so he lost the game."));
                System.out.println("Winner :: " + dealer.getName());
                break;
            }

            if (dealer.getHand().calculateHandValue() > 21) {
                System.out.println(dealer.getName().concat(" has score greater than 21 so he lost the game."));
                System.out.println("Winner :: " + player.getName());
                break;
            }

            if (player.getHand().calculateHandValue() >= 17
                    && dealer.getHand().calculateHandValue() > player.getHand().calculateHandValue()
                    && dealer.getHand().calculateHandValue() <=21) {
                System.out.println(dealer.getName().concat(" has score ".concat(String.valueOf(dealer.getHand().calculateHandValue()))
                        + "greater than "+player.getHand()+" so Dealer won the game."));
                System.out.println("Winner :: " + player.getName());
                break;
            }

        }


    }

    private void ExecuteRules() {

    }

    public String readInput(String filePath) {
        String content = null;
        try {
            File file = ResourceUtils.getFile(filePath);
            content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
