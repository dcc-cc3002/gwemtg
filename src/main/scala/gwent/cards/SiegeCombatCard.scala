
package cl.uchile.dcc
package gwent.cards

import java.util.Objects

/** Class representing a siege combat unit card in the Gwen't game.
 *
 * A `SiegeCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent siege machinery used on the battlefield.
 * As per the game's rules, these cards can only be placed in the siege combat zone.
 *
 * @constructor create a new siege combat card with name, description, and power.
 * @param name the name of the card.
 * @param cost how much mana is required to cast a card
 * @param power the initial power value of the card, which also corresponds to the siege
 *              machinery's strength.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author hugodiazroa
 * @version 1.1
 * @since 1.0
 */
class SiegeCombatCard(name: String, cost: Int, power: Int) extends AbstractUnitCard(name, cost, power){
  /** sobreescribimos hashCode para hacer classOf[UnitCard] */
  override def hashCode: Int = Objects.hash(classOf[SiegeCombatCard], name, power, cost)

  /** sobreescribimos canEqual para hacer .isInstanceOf[UnitCard] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCombatCard]

  /** sobreescibimos equals para que compare los parametros nuevos de UnitCard */
  override def equals(uc: Any): Boolean = uc match {
    case uc: SiegeCombatCard => uc.canEqual(this) && this.name == uc.name && this.power == uc.power && this.cost == uc.cost
    case _ => false
  }
}

