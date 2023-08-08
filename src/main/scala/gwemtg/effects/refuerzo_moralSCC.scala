package hugodiazroa
package gwemtg.effects

/**
 * refuerzo_moral
 * this trait extends SiegeCombatCards and grants the following effect:
 * all the units in the exact same zone gain +1 power
 */

import gwemtg.cards.SiegeCombatCard
import gwemtg.{Game, Player}

class refuerzo_moralSCC(name: String, description: String, power: Int, cmc: Int) extends SiegeCombatCard(name, description, power, cmc) {

  override def effect(player: Player, game: Game): Unit = {
    if (player == game.getP1) {
      for (card <- game.board.p1s.data) card.setPower(card.getPower + 1)
    }

    if (player == game.getP2){
      for (card <- game.board.p2s.data) card.setPower(card.getPower + 1)
    }
  }
}

