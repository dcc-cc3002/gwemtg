
package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import java.util.Objects

class RangeZone(var data: List[RangedCombatCard]) extends AbstractZone(data: List[Any]) {
  def this() = this(List())
}

