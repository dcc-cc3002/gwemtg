package hugodiazroa
package gwemtg.effects

/**
 * refuerzo_moral
 * this trait extends RangedCombatCards and grants the following effect:
 * all the units in the exact same zone gain +1 power
 */

import gwemtg.cards.RangedCombatCard
import gwemtg.{Game, Player}

class refuerzo_moralRCC(name: String, description: String, power: Int, cmc: Int) extends RangedCombatCard(name, description, power, cmc) {

  override def effect(player: Player, game: Game): Unit = {
    if (player == game.getP1) {
      for (card <- game.board.p1r.data) card.setPower(card.getPower + 1)
    }

    if (player == game.getP2){
      for (card <- game.board.p2r.data) card.setPower(card.getPower + 1)
    }
  }
}

