
package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import java.util.Objects

class RangeZone(var data: List[RangedCombatCard]) extends Zone {
  /** constructor for empty zone */

  def this() = this(List())

  /**
   * add a card to the zone 
   * this appends the card to the current list of cards
   */
  def add(card: RangedCombatCard): Unit = {
    data = card :: data
  }
}

