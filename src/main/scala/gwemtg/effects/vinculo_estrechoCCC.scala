package hugodiazroa
package gwemtg.effects


/**
 * vinculo_estrecho
 * this trait extends CloseCombatCards and grants the following effect:
 * all the units in the exact name in the zone duplicate their power
 */

import gwemtg.{Game, Player}
import gwemtg.cards.*

class vinculo_estrechoCCC(name: String, description: String, power: Int, cmc: Int) extends CloseCombatCard(name, description, power, cmc)  {

  override def effect(player: Player, game: Game): Unit = {

    if (player == game.getP1) {
      for (card <- game.board.p1m.data) card.setPower(card.getPower + card.getPower)
    }

    if (player == game.getP2){
      for (card <- game.board.p2m.data) card.setPower(card.getPower + card.getPower)
    }
  }

}

