/**
  * in this state it is answered the question weahter there are alive players or not
  */

class SubstractGems extends States {
    override def SubstractGems(stateofgame: StateOfGame): Unit = {
        val p1lifes: int =  stateofgame.getMatch.getP1.getGems
        val p2lifes: int =  stateofgame.getMatch.getP2.getGems
        if p1lifes == 0 || p2lifes == 0 {
            changeState(stateofgame, new Draw())
        } else if p1lifes == 0 {
            changeState(stateofgame, new P2Win())
        } else if p2lifes == 0 {
            changeState(stateofgame, new P1Win())
        } else {
            changeState(stateofgame, new PlayRound())
        }
    }

    override def isSubstractGems(): Boolean = true
}