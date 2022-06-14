package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.enums.GameStatus;
import com.demo.assignment.blackjack.exception.InvalidInputException;
import com.demo.assignment.blackjack.model.GameResult;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

public class Game {

    /**
     * This game is designed to play just one round. It can be modified a bit to play multiple rounds with multiple players
     */
    public GameResult startGame(String playerName, String inputFilePath) {
        String fileContent = readInput(inputFilePath);
        CardDeck cardDeck;
        GameResult gameResult;
        cardDeck = new CardDeck();
        Person dealer = new Person("Dealer");
        Person player = new Person(playerName);
        if (ObjectUtils.isEmpty(fileContent)) {
            System.out.println("Didn't find any input parameters so initializing random deck of 52 cards");
            cardDeck.generateCardDeck();
            cardDeck.shuffleDeck();
        } else {
            Set packForCards;
            String[] cards = fileContent.split(",");
            try {
                packForCards = cardDeck.validateCardInput(cards);
            } catch (InvalidInputException e) {
                e.printStackTrace();
                gameResult = new GameResult(player.getName(), "Invalid Input, Make sure you have correct input format :: \n " +
                        "Below are some example formats :: H10, S5, CA, D9, D3, C6......", GameStatus.TERMINATED);

                return gameResult;
            }
            cardDeck.generateCardDeck(packForCards);
            System.out.println("initializing cards from input file");
        }
        System.out.println(cardDeck);

        /**
         * Initially 2-2 cards will be drawn from the deck
         */
        player.getHand().takeCardFromDeck(cardDeck);
        dealer.getHand().takeCardFromDeck(cardDeck);
        player.getHand().takeCardFromDeck(cardDeck);
        dealer.getHand().takeCardFromDeck(cardDeck);

        if (player.hasBlackjack() || dealer.hasBlackjack()) {
            /**
             * If both Player and Dealer has blackJack then also Player is going to win
             */
            if (player.getHand().calculateHandValue() >= dealer.getHand().calculateHandValue()) {
                gameResult = new GameResult(player.getName(), player.getName().concat(" won the game as he has blackJack"), GameStatus.FINISHED);
            } else {
                gameResult = new GameResult(dealer.getName(), dealer.getName().concat(" won the game as he has blackJack"), GameStatus.FINISHED);
            }
            return gameResult;
        }

        /**
         * If both starts with 2 Aces then dealer wins
         */
        if (player.hasBothAceInHand() && dealer.hasBothAceInHand()) {
            gameResult = new GameResult(dealer.getName(), dealer.getName().concat(" won the game as both starts with Ace"), GameStatus.FINISHED);
            return gameResult;
        }
        /**
         * Player will keep drawing card until its reached 17 or higher
         */
        while (player.getHand().calculateHandValue() < 17) {
            player.getHand().takeCardFromDeck(cardDeck);
        }
        /**
         * Player loose the game if card reaches greater than 21
         */
        if (player.getHand().calculateHandValue() > 21) {
            gameResult = new GameResult(dealer.getName(), dealer.getName().concat(" won the game as " + player.getName() + " total reached greater than 21"), GameStatus.FINISHED);
            return gameResult;
        }
        /**
         * Now its dealer turn to show their card and draw card until its greater than player card.
         */
        while (dealer.getHand().calculateHandValue() > player.getHand().calculateHandValue()) {
            player.getHand().takeCardFromDeck(cardDeck);
        }

        if (dealer.getHand().calculateHandValue() > 21) {
            gameResult = new GameResult(player.getName(), player.getName().concat(" won the game as " + dealer.getName() + " total reached greater than 21"), GameStatus.FINISHED);
            return gameResult;
        }

        if (dealer.getHand().calculateHandValue() > player.getHand().calculateHandValue()) {
            gameResult = new GameResult(dealer.getName(), dealer.getName().concat(" won the game."), GameStatus.FINISHED);
        } else {
            gameResult = new GameResult(player.getName(), player.getName().concat(" won the game."), GameStatus.FINISHED);
        }

        System.out.println("Here is the summery of cards :: ");
        System.out.println(player.getHandToPrint());
        System.out.println(dealer.getHandToPrint());
        System.out.println("Here is the winner :: " + gameResult.getWinner());
        return gameResult;

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
