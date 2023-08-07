package cl.uchile.dcc
package gwemtg.states

/** here climate effects are played
  * if player 2 plays a climate card it resolves
  * if player 1 plays a climate card and player 2 does not, it resolves
  * when a climate card is resolved, it applies its effect to the board
  * the effect is lasting, so it will be applied each round as long as the card is there
  */


/** I won't implement this class until the effects are done for ClimateCards
  * anyways, the basic structure must be built
  * here it is, it does nothing
  */

import gwemtg.states.*

class ChangeBoard extends Estado {
    override def ChangeBoard(): Unit = {
        this.changeState(stateofgame, new PlayRound())
    }
}