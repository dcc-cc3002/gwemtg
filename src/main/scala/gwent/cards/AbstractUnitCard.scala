
package cl.uchile.dcc
package gwent.cards

import gwent.Board
import gwent.Player

import java.util.Objects


/** Abstract class representing a unit card in the Gwen't game.
 *
 * An `AbstractUnitCard` is a type of [[Card]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, description, and
 *              power.
 * @param name The name of the card.
 * @param cost The cost means how much mana is required to cast a card
 * @param power The base power of the card, indicating the contribution of this card to
 *              the player's total power when unaffected by any special conditions.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 *         (comenta en ingles)
 * @author hugodiazroa
 *         (comenta en espanxol)
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractUnitCard protected(val name: String, val cost: Int, val power: Int) extends Card {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  var currentPower: Int = power


  /** sobreescribimos hashCode para hacer classOf[UnitCard] */
  override def hashCode: Int = Objects.hash(classOf[AbstractUnitCard], name, power, cost)

  /** sobreescribimos canEqual para hacer .isInstanceOf[UnitCard] */
  def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractUnitCard]

  /** sobreescibimos equals para que compare los parametros nuevos de UnitCard */
  override def equals(uc: Any): Boolean = uc match {
    case uc: AbstractUnitCard => uc.canEqual(this) && this.name == uc.name && this.power == uc.power && this.cost == uc.cost
    case _ => false
  }

}
