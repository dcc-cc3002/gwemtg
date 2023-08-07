package cl.uchile.dcc
package gwent

/**
  * CDHAM: Create Decks, Hands, and Match
  * in this state we override the method CDHAM 
  * we begin by creating the decks and the handsof the players
  * putting the player in the game
  * and then changing the state to PlayRound
  */

import gwent.states.*

class CDHAM extends States {
    override def CDHAM(stateofgame: StateOfGame): Unit = {
        this.stateofgame.createDecks()
        this.stateofgame.createHands()
        this.stateofgame.createMatch()
        /** we make sure both players begin with the gems according to whats stipulated in the rules */
        assert(stateofgame.getMatch().getP1.getGems() == 2)
        assert(stateofgame.getMatch().getP2.getGems() == 2)
        this.changeState(stateofgame, new PlayRound())
    }

    override def isCDHAM(): Boolean = true
}