package cl.uchile.dcc
package gwent

/**
  * in this state it is answered the question weahter there are alive players or not
  */

import gwent.Player
import gwent.board.*
import gwent.cards.*

class SubstractGems extends Estado {
    override def SubstractGems(stateofgame: StateOfGame): Unit = {
        val p1lifes: Int =  stateofgame.getMatch.getP1.getGems
        val p2lifes: Int =  stateofgame.getMatch.getP2.getGems
        if p1lifes == 0 || p2lifes == 0 then this.changeState(stateofgame, new Draw())
        else if p1lifes == 0 then this.changeState(stateofgame, new P2Win())
        else if p2lifes == 0 then this.changeState(stateofgame, new P1Win())
        else this.changeState(stateofgame, new PlayRound())
    }

    override def isSubstractGems: Boolean = true
}