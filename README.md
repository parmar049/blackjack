# Getting Started

Welcome to BlackJack. This code is to solve the problem of Beat at 21. Currently there are 2 Players Dealer and one player 
playing each other to beat at 21.

**Here is the rules for the game**

• determine score of a hand[1]
• check if either player has Blackjack with their initial hand and wins the game. 
Blackjack is an initial score of 21 with two cards: A + [10, J, Q, K]
• sam wins when both players starts with Blackjack
• dealer wins when both players starts with 22 (A + A)
• if neither player has Blackjack then sam can start drawing cards from the top 
of the deck
• sam must stop drawing cards from the deck if their total reaches 17 or higher
• sam has lost the game if their total is higher than 21
• when sam has stopped drawing cards the dealer can start drawing cards from 
the top of the deck
• the dealer must stop drawing cards when their total is higher than sam.
• the dealer has lost the game if their total is higher than 21
• determine which player wins the game (highest score wins)

**Note:** Numbered cards are their point value. Jack, Queen and King count as 10 and Ace counts as 11

### Technical Details

This is simple Java Program which is printing outputs in console also uses Junit to test the different Scenarios.

Use below command to run application which will execute main() method.
mvn spring-boot:run

Use below command to run build and unit test
mvn clean install


