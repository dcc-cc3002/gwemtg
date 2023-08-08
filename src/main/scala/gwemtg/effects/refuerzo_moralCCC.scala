package hugodiazroa
package gwemtg.effects

/**
 * refuerzo_moral
 * this trait extends CloseCombatCards and grants the following effect:
 * all the units in the exact same zone gain +1 power
 */

import gwemtg.cards.CloseCombatCard
import gwemtg.{Game, Player}

class refuerzo_moralCCC (name: String, description: String, power: Int, cmc: Int) extends CloseCombatCard(name, description, power, cmc) {

  override def effect(player: Player, game: Game): Unit = {
    if (player == game.getP1) {
      for (card <- game.board.p1m.data) card.setPower(card.getPower + 1)
    }

    if (player == game.getP2){
      for (card <- game.board.p2m.data) card.setPower(card.getPower + 1)
    }
  }
}

