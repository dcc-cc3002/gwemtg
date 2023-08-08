package hugodiazroa
package gwemtg.effects

/**
 * set_power_of_row_to_x
 * this trait extends the WheatherCard class
 * it sets a row from 1 to 3 to an interger value (bigger that zero)
 */

import gwemtg.{Game, Player}
import gwemtg.board.*
import gwemtg.cards.*



trait set_power_of_zone_to_x(row: Int, x: Int) extends WeatherCard {
  override def effect(player: Player, game: Game): Unit = {
    if (player == game.getP1) {
      row match {
        case 1 => for (card <- game.board.p1m.data) card.setPower(x)
        case 2 => for (card <- game.board.p1r.data) card.setPower(x)
        case 3 => for (card <- game.board.p1s.data) card.setPower(x)
      }
    } else if (player == game.getP2) {
      row match {
        case 1 => for (card <- game.board.p2m.data) card.setPower(x)
        case 2 => for (card <- game.board.p2r.data) card.setPower(x)
        case 3 => for (card <- game.board.p2s.data) card.setPower(x)
      }
    }
  }

}
