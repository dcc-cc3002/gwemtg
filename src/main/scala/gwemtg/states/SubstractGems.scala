package hugodiazroa
package gwemtg
package states

/**
  * in this state it is answered the question weahter there are alive players or not
  */

import gwemtg.Player
import gwemtg.board.*

class SubstractGems extends Estado {
    override def SubstractGems(stateofgame: StateOfGame): Unit = {
        if (stateofgame.game.boardPoints(stateofgame.player1)==stateofgame.game.boardPoints(stateofgame.player2)){
            stateofgame.player1.loseGem()
            stateofgame.player2.loseGem()
        } else if (stateofgame.game.boardPoints(stateofgame.player1) > stateofgame.game.boardPoints(stateofgame.player2)) {
            stateofgame.player2.loseGem()
        } else {stateofgame.player1.loseGem()}

        val p1lifes: Int = stateofgame.player1.getGems
        val p2lifes: Int = stateofgame.player2.getGems
      
        if p1lifes == 0 && p2lifes == 0 then this.changeState(stateofgame, new Draw())
        else if p1lifes == 0 then this.changeState(stateofgame, new P2Win())
        else if p2lifes == 0 then this.changeState(stateofgame, new P1Win())
        else this.changeState(stateofgame, new PlayRound())
    }
    
}