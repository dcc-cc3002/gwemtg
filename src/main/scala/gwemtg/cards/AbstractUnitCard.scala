
package cl.uchile.dcc
package gwemtg
package cards

import java.util.Objects
import scala.collection.mutable

/** Abstract class representing a unit card in the Gwen't game.
 *
 * An `AbstractUnitCard` is a type of [[Card]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, description, and
 *              power.
 * @param name The name of the card.
 * @param description The description of the card, explaining its specific abilities or
 *                    role in the game.
 * @param power The base power of the card, indicating the contribution of this card to
 *              the player's total power when unaffected by any special conditions.
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractUnitCard (val name: String, val description: String, val power: Int) extends Card with Equals {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  private var currentPower: Int = power

  /** The original power of the card, which is used to reset the current power of the card
   * this is what would be printed on the card in a physical game.
   */
  private val originalPower: Int = power
  
  
}

