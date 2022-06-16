package com.demo.assignment.blackjack.Service;

import com.demo.assignment.blackjack.model.Result;

public interface BlackJack {

    Result getWinner(String playerName, String input);

}
