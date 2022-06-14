package com.demo.assignment.blackjack;

import com.demo.assignment.blackjack.constants.Constants;
import com.demo.assignment.blackjack.enums.GameStatus;
import com.demo.assignment.blackjack.exception.InvalidInputException;
import com.demo.assignment.blackjack.model.Result;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.function.Supplier;

public class Game {

    /**
     * This game is designed to play just one round. It can be modified a bit to play multiple rounds with multiple players
     */
    public Result startGame(String playerName, String inputFilePath) {

        String fileContent = readInput(inputFilePath);
        CardDeck cardDeck;
        Result gameResult;
        cardDeck = new CardDeck();
        Person dealer = new Person(Constants.DEALER_NAME);
        Person player = new Person(playerName);
        if (ObjectUtils.isEmpty(fileContent)) {
            System.out.println(Constants.INPUT_MISSING_ERROR);
            cardDeck.generateCardDeck();
            cardDeck.shuffleDeck();
        } else {
            Set packForCards;
            String[] cards = fileContent.split(Constants.DELIMETER);
            try {
                packForCards = cardDeck.validateCardInput(cards);
            } catch (InvalidInputException e) {
                e.printStackTrace();
                gameResult = new Result(player.getName(), Constants.INVALID_INPUT_MSG +
                        Constants.EXAMPLE_MSG, GameStatus.TERMINATED, null);

                return gameResult;
            }
            cardDeck.generateCardDeck(packForCards);
            System.out.println(Constants.INITIALIZE_MSG);
        }
        System.out.println(cardDeck);

        Supplier<String> gameSummery = () -> Constants.SUMMERY_MSG.concat(player.getName()).concat(" | ").concat(dealer.getName()).
                concat("\n").concat(player.getName()).concat(" :: ").concat(player.getHand().getHandToPrint().toString()).
                concat("\n").concat(dealer.getName()).concat(" :: ").concat(dealer.getHand().getHandToPrint().toString());

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
                gameResult = new Result(player.getName(), player.getName().concat(Constants.BLACKJACK_MSG),
                        GameStatus.FINISHED, gameSummery);
            } else {
                gameResult = new Result(dealer.getName(), dealer.getName().concat(Constants.BLACKJACK_MSG),
                        GameStatus.FINISHED, gameSummery);
            }
            return gameResult;
        }

        /**
         * If both starts with 2 Aces then dealer wins
         */
        if (player.hasBothAceInHand() && dealer.hasBothAceInHand()) {
            gameResult = new Result(dealer.getName(), dealer.getName().concat(Constants.ACE_WIN_MSG), GameStatus.FINISHED,
                    gameSummery);
            return gameResult;
        }
        /**
         * Player will keep drawing card until its reached 17 or higher
         */
        while (player.getHand().calculateHandValue() < Constants.MIN_NUMBER_TO_DRAW_CARD) {
            player.getHand().takeCardFromDeck(cardDeck);
        }
        /**
         * Player loose the game if card reaches greater than 21
         */
        if (player.getHand().calculateHandValue() > Constants.MAX_NUMBER_TO_STOP_GAME) {
            gameResult = new Result(dealer.getName(), dealer.getName().concat(Constants.WIN_MSG + player.getName()
                    + Constants.TOTAL_HIGHER_THAN_DEFINED_MSG), GameStatus.FINISHED, gameSummery);
            return gameResult;
        }
        /**
         * Now its dealer turn to show their card and draw card until its greater than player card.
         */
        while (dealer.getHand().calculateHandValue() < player.getHand().calculateHandValue()) {
            dealer.getHand().takeCardFromDeck(cardDeck);
        }

        if (dealer.getHand().calculateHandValue() > Constants.MAX_NUMBER_TO_STOP_GAME) {
            gameResult = new Result(player.getName(), player.getName().concat(Constants.WIN_MSG + dealer.getName()
                    + Constants.TOTAL_HIGHER_THAN_DEFINED_MSG), GameStatus.FINISHED, gameSummery);
            return gameResult;
        }

        if (dealer.getHand().calculateHandValue() > player.getHand().calculateHandValue()) {
            gameResult = new Result(dealer.getName(), dealer.getName().concat(Constants.WIN_MSG2), GameStatus.FINISHED, gameSummery);
        } else {
            gameResult = new Result(player.getName(), player.getName().concat(Constants.WIN_MSG2), GameStatus.FINISHED, gameSummery);
        }

        return gameResult;

    }

    public String readInput(String filePath) {
        String content = null;
        try {
            File file = ResourceUtils.getFile(filePath);
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_MISSING_MSG + filePath);
        } catch (IOException e) {
            System.out.println(Constants.FILE_READ_MSG + filePath);
        }
        return content;
    }

}
