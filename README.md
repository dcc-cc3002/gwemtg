# GweMTG

## By
* HD (github.com/hugodiazroa)

## Description
Gwemt is a trading card game based upon Gwen from the Witcher series with "Magic the Gathering" themed cards. The game is played over a best-of-three series of rounds, as players unleash their hand by slinging spells and diverse units with special abilities.
There are four types of cards: 
• Climate cards
• Close combat unit cards
• Ranged unit cards
• Siege unit cards

The game is played by two players. In this iteration of the development of the game the only implementaion of the code we will only cover the case of a  match between a human and a robot ~todo: robot v robot~

Under this rules, the human player is the one who starts the game and the computer player is the one who responds to the human player's actions. The game is played in turns, where each player can play a card or pass.  The first round players draw 10 cards, then 3 cards at the beginning of each round. ~The player who starts is always the human.~ 

A round ends when both players pass. The player who wins the round is the one who has the highest power. If both players have the same power, the round ends in a draw. The loser of a round starts the next round and loses a gem.

If a player has zero or less gems, they lose the game. The winner is the one to finish a round being the only one to have not lost. In case of a draw, both players lose a gem and the player who started the previuos round starts the next again. In case, after a draw, all players have lost, the game ends in a draw.


The game is played over a board which is divided into seven rows, 
   • A shared row for weather cards 
   • The melee row, for each player 
   • The ranged row, for each player
   • The siege row, for each player

Each player has a deck of cards which contains 25 cards. Each card has a name and a description ~todo: change description to oracle pattern??~. Unit cards also have power. 




## How to run the game
The game runs on the console after excecuting the Controller object. The game is played by entering the number of the card you want to play. The game ends when one of the players wins two rounds and then the program excecuting ends.

## State diagram
![Untitled_Diagram](https://github.com/dcc-cc3002/gwemtg/assets/16340209/ac5272fb-d807-4a98-af4e-5dff1f074e1c)




![http://creative![Uploading Untitled Diagram.jpg…]()
commons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[__](https://www.play.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**
