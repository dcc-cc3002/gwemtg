package hugodiazroa
package gwemtg.effects

import gwemtg.cards.{AbstractUnitCard, CloseCombatCard, RangedCombatCard, SiegeCombatCard}

import hugodiazroa.gwemtg.{Game, Player}

/**
 * refuerzo_moral
 * this trait extends CloseCombatCards and grants the following effect:
 * all the units in the exact same zone gain +1 power
 */

trait refuerzo_moral extends AbstractUnitCard {
  override def effect(player: Player, game: Game): Unit = {
    var x: Int = 0
    if (this.getClass == new CloseCombatCard("a","a",1,1).getClass) x = 1
    if (this.getClass == new RangedCombatCard("a","a",1,1).getClass) x = 2
    if (this.getClass == new SiegeCombatCard("a","a",1,1).getClass) x = 3

    if (player == game.getP1) {
      x match {
        case 1 => for (card <- game.board.p1m.data) card.setPower(card.getPower + 1)
        case 2 => for (card <- game.board.p1r.data) card.setPower(card.getPower + 1)
        case 3 => for (card <- game.board.p1s.data) card.setPower(card.getPower + 1)
      }
    }

    if (player == game.getP2){
      x match {
        case 1 => for (card <- game.board.p2m.data) card.setPower(card.getPower + 1)
        case 2 => for (card <- game.board.p2r.data) card.setPower(card.getPower + 1)
        case 3 => for (card <- game.board.p2s.data) card.setPower(card.getPower + 1)
      }
    }
  }
}

