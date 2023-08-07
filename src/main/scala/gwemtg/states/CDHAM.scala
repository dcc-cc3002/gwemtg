package cl.uchile.dcc
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

class CDHAM extends Estado {
    override def CDHAM(stateofgame: StateOfGame): Unit = {
        val tupla_mazos = stateofgame.createDecks
        val tupla_manos = stateofgame.createHands
        val tablero: Board = new Board()
        var juego: Game = new Game()
        juego = stateofgame.createMatch(tupla_mazos._1, tupla_mazos._2, tupla_manos._1, tupla_manos._2, tablero, juego)
        /** we make sure both players begin with the gems according to whats stipulated in the rules */
        assert(stateofgame.getMatch().getP1.getGems() == 2)
        assert(stateofgame.getMatch().getP2.getGems() == 2)
        this.changeState(stateofgame, new PlayRound())
    }

    override def isCDHAM(): Boolean = true
}