
package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import java.util.Objects

class MeleeZone(var data: List[CloseCombatCard]) extends Zone with Equals {
  /** constructor for empty zone */

  def this() = this(List())

  /**
   * override for hashcode
   */
  override def hashCode(): Int = {
    var result: Int = 0
    for (card <- data) {
      result = result + (card.hashCode() % 1000000007)
    }
    return Objects.hash(classOf[MeleeZone], result)
  }

  /** canEqual definition */
  def canEqual(other: Any): Boolean = other.isInstanceOf[MeleeZone]

  /**
   * override for equals
   */
  override def equals(other: Any): Boolean = {
    other match {
      case other: MeleeZone => {
        other.canEqual(this) &&
          this.hashCode() == other.hashCode()
      }
      case _ => false
    }
  }

  /** toString 
   * override of the toString method
   *
   * @return a string representation of the board
   */
  override def toString: String = {
    var result: String = ""
    for (card <- data) {
      result = result + card.toString() + "\n"
    }
    result
  }
  
}
