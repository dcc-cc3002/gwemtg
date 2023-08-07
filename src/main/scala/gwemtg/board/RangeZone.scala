package hugodiazroa
package gwemtg.board

import gwemtg.cards.*

import java.util.Objects

class RangeZone(var data: List[RangedCombatCard]) extends Zone with Equals {
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
    return Objects.hash(classOf[RangeZone], result)
  }

  /** canEqual definition */
  def canEqual(other: Any): Boolean = other.isInstanceOf[RangeZone]

  /**
   * override for equals
   */
  override def equals(other: Any): Boolean = {
    other match {
      case other: RangeZone => {
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
      result = result + card.getName + " " + card.getPower + "\n"
    }
    if (result != "") then result = result.substring(0, result.length - 1)
    return result
  }

}

