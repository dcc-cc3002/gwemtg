package hugodiazroa
package gwemtg.effects


/**
 * vinculo_estrecho
 * this trait extends CloseCombatCards and grants the following effect:
 * all the units in the exact name in the zone duplicate their power
 */

import gwemtg.{Game, Player}
import gwemtg.cards.*

trait vinculo_estrecho extends AbstractUnitCard {
  override def effect(player: Player, game: Game): Unit = {
    var x: Int = 0
    if (this.getClass == new CloseCombatCard("a","a",1,1).getClass) x = 1
    if (this.getClass == new RangedCombatCard("a","a",1,1).getClass) x = 2
    if (this.getClass == new SiegeCombatCard("a","a",1,1).getClass) x = 3

    if (player == game.getP1) {
      x match {
        case 1 => for (card <- game.board.p1m.data) card.setPower(card.getPower + card.getPower)
        case 2 => for (card <- game.board.p1r.data) card.setPower(card.getPower + card.getPower)
        case 3 => for (card <- game.board.p1s.data) card.setPower(card.getPower + card.getPower)
      }
    }

    if (player == game.getP2){
      x match {
        case 1 => for (card <- game.board.p2m.data) card.setPower(card.getPower + card.getPower)
        case 2 => for (card <- game.board.p2r.data) card.setPower(card.getPower + card.getPower)
        case 3 => for (card <- game.board.p2s.data) card.setPower(card.getPower + card.getPower)
      }
    }
  }
}

