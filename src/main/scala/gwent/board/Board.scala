
package cl.uchile.dcc
package gwent.board

import gwent.cards.*
import gwent.Player

import java.util.Objects

/**
 * This class represents the board of the game.
 * The board is composed of 7 zones, 3 for each player and 1 for the climate.
 *
 * 
 * The board is composed of 7 zones:
 * - player 1's marginal: zone where siege combat cards are played.
 * - player 1's ranged: zone where ranged combat cards are played.
 * - player 1's melee: zone where close combat cards are played.
 * - climate: zone where climate cards are played.
 * - player 2's melee: zone where close combat cards are played.
 * - player 2's ranged: zone where ranged combat cards are played.
 * - player 2's marginal: zone where siege combat cards are played.
 *
 *
 */
class Board(var p1s: MarginalZone, var p1r: RangeZone, var p1m: MeleeZone, var clima: ClimateZone, var p2m: MeleeZone, var p2r: RangeZone, var p2s: MarginalZone) {

  /** constructor for an empty board */
  def this() = this(new MarginalZone(), new RangeZone(), new MeleeZone(), new ClimateZone(), new MeleeZone(), new RangeZone(), new MarginalZone())

  /** Checks if two objects belong to the class Board */
  def canEqual(a: Any): Boolean = a.isInstanceOf[Board]

  /** override de Equals */
  override def equals(obj: Any): Boolean = {
    obj match {
      case board: Board => this.canEqual(board) &&  this.hashCode() == board.hashCode()
      case _ => false
    }
  }

  /** override de hashCode */
  override def hashCode(): Int = {
    var result: Int = 0
    for (card <- p1s.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    result = result % 1000000007
    for (card <- p1r.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    result = result % 1000000007
    for (card <- p1m.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    result = result % 1000000007
    for (card <- clima.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    result = result % 1000000007
    for (card <- p2m.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    result = result % 1000000007
    for (card <- p2r.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    result = result % 1000000007
    for (card <- p2s.data) {if (card != null) result = result + (card.hashCode() % 1000000007) }
    return Objects.hash(classOf[Board], result)
  }


}
