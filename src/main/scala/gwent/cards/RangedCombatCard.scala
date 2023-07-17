
package cl.uchile.dcc
package gwent.cards

import java.util.Objects

/** Class representing a ranged combat unit card in the Gwen't game.
 *
 * A `RangedCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in ranged combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the ranged combat zone.
 *
 * @constructor create a new ranged combat card with name, description, and power.
 * @param name the name of the card.
 * @param description the description of the card.
 * @param power the initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
class RangedCombatCard(name: String, description: String, power: Int) extends AbstractUnitCard(name, description, power){

  /** Checks if two objects belong to the class RangedCombatCard */
  def canEqual(other: Any): Boolean = other.isInstanceOf[RangedCombatCard]

  /** overwrite equals for CloseCombatCard */
  override def equals(rcc: Any): Boolean = rcc match {
    case rcc: RangedCombatCard => rcc.canEqual(this) && this.getName == rcc.getName && this.getDescription == rcc.getDescription && this.getPower == rcc.getPower
    case _ => false
  }


  /** overwrite hashcode */

  override def hashCode: Int = {
    if this == null then return Objects.hash(classOf[RangedCombatCard], null)
    else return Objects.hash(classOf[RangedCombatCard], name)
  }
}

