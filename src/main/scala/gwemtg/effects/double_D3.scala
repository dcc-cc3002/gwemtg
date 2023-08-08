package hugodiazroa
package gwemtg.effects

/** double_D3
  * this effect is an effect that belongs to a wheather card
  * it doubles the power of a whole row of your own cards
  * it is a class that extends the wheather card type
  * it is called D3 because it doubles the power of one of the three rows, at random
  */

import gwemtg.Player
import gwemtg.Game
import gwemtg.board.*
import gwemtg.cards.*

class double_D3(override val name: String, override val description: String) extends WeatherCard(name, description) {
  override def effect(player: Player, game: Game): Unit ={
    val row = scala.util.Random.nextInt(3)
    if (player == game.getP1 ) {
      val rand = new scala.util.Random
      val row = rand.nextInt(3)
      row match
        case 0 => for (card <- game.board.p1m.data) {
          card.setPower(card.getPower * 2)
        }
        case 1 => for (card <- game.board.p1r.data) {
          card.setPower(card.getPower * 2)
        }
        case 2 => for (card <- game.board.p1s.data) {
          card.setPower(card.getPower * 2)
        }
    }
    else if (player == game.getP2) {
      val rand = new scala.util.Random
      val row = rand.nextInt(3)
      row match
        case 0 => for (card <- game.board.p2m.data) {
          card.setPower(card.getPower * 2)
        }
        case 1 => for (card <- game.board.p2r.data) {
          card.setPower(card.getPower * 2)
        }
        case 2 => for (card <- game.board.p2s.data) {
          card.setPower(card.getPower * 2)
        }
    }
  }
}
