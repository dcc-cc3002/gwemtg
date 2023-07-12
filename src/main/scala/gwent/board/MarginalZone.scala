
package cl.uchile.dcc
package gwent.board

import gwent.cards.*
import java.util.Objects

class MarginalZone(var data: List[SiegeCombatCard]) extends AbstractZone(data: List[Any]){

  def this() = this(List())
  
}
