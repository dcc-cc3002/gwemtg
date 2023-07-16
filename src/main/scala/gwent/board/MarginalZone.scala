
package cl.uchile.dcc
package gwent.board

import gwent.cards.*
import java.util.Objects

class MarginalZone(var data: List[SiegeCombatCard]) extends Zone {

  def this() = this(List())
  
}
