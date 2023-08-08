package hugodiazroa
package gwemtg
package states

/**
  * CDHAM: Create Decks, Hands, and Match
  * in this state we override the method CDHAM 
  * we begin by creating the decks and the handsof the players
  * putting the player in the game
  * and then changing the state to PlayRound
  */

import gwemtg.states.*
import gwemtg.Game
import gwemtg.board.Board
import gwemtg.cards.*

class CDHAM extends Estado {
    override def CDHAM(stateofgame: StateOfGame): Unit = {
        val deck_builder = new DeckBuilder()
        var deckP1: List[Card] = deck_builder.buildDeck()
        var deckP2: List[Card] = deck_builder.buildDeck()
        stateofgame.player1 = new Player("human", 2, deckP1, List())
        stateofgame.player2 = new Player("robot", 2, deckP2, List())
        stateofgame.player1.drawInitialHand()
        stateofgame.player2.drawInitialHand()
        stateofgame.board = new Board()
        stateofgame.game = new Game(stateofgame.board, stateofgame.player1, stateofgame.player2)
        /** we make sure both players begin with the gems according to whats stipulated in the rules */
        assert(stateofgame.player1.getGems == 2)
        assert(stateofgame.player2.getGems == 2)
        this.changeState(stateofgame, new PlayRound())
    }

}