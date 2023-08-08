package hugodiazroa
package gwemtg.effects



/** void_world
 * this effect is an effect that belongs to a wheather card
 * it resets the power of every card to their original power
 */

import gwemtg.{Game, Player}
import gwemtg.cards.WeatherCard

class void_world(override val name: String, override val description: String) extends WeatherCard(name, description) {

    override def effect(player: Player, game: Game): Unit = {
    for (card <- game.board.p1m.data) card.setPower(card.getOGPower)
    for (card <- game.board.p1r.data) card.setPower(card.getOGPower)
    for (card <- game.board.p1s.data) card.setPower(card.getOGPower)
    for (card <- game.board.p2m.data) card.setPower(card.getOGPower)
    for (card <- game.board.p2r.data) card.setPower(card.getOGPower)
    for (card <- game.board.p2s.data) card.setPower(card.getOGPower)
  }
}