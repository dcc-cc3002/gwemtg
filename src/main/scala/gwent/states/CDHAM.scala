/**
  * CDHAM: Create Decks, Hands, and Match
  * in this state we override the method CDHAM 
  * we begin by creating the decks and the handsof the players
  * putting the player in the game
  * and then changing the state to PlayRound
  */

class CDHAM extends States {
    override def CDHAM(stateofgame: StateOfGame): Unit = {
        stateofgame.createDecks()
        stateofgame.createHands()
        stateofgame.createMatch()
        assert(stateofgame.getMatch().getPlayer1.getGems() == 2)
        assert(stateofgame.getMatch().getPlayer2.getGems() == 2)
        changeState(stateofgame, new PlayRound())
    }

    override def isCDHAM(): Boolean = true
}