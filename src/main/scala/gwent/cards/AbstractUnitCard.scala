
package cl.uchile.dcc
package gwent.cards

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
 * @author hugodiazroa
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractUnitCard protected(val name: String, val cost: Int, val power: Int) extends Card {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  var currentPower: Int = power
}

