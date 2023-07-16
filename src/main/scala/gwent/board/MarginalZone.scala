
package cl.uchile.dcc
package gwent.board

import gwent.cards.*
import java.util.Objects

class MarginalZone(var data: List[SiegeCombatCard]) extends Zone {
  /** constructor for empty zone */

  def this() = this(List())

  /**
   * override for hashcode
   */
  override def hashCode(): Int = {
    var result = 0
    for (card <- data) {
      result += Objects.hash(card)
    }
    result
  }
  /**
   * add a card to the zone 
   * this appends the card to the current list of cards
   */
  def add(card: SiegeCombatCard): Unit = {
    data = card :: data
  }
}
