
package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import java.util.Objects

class MeleeZone(var data: List[CloseCombatCard]) extends AbstractZone(data: List[Any]){
  def this() = this(List())

}
