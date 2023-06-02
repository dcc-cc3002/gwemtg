
package cl.uchile.dcc
package gwent.cards

/** Class representing a close combat unit card in the Gwen't game.
 *
 * A `CloseCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `CloseCombatCard` with a specified name, description, and
 *              power.
 * @param name the name of the card.
 * @param description the description of the card.
 * @param power the initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author hugodiazroa
 * @version 1.1
 * @since 1.0
 */
class CloseCombatCard(name: String, description: String, power: Int)
  extends AbstractUnitCard(name, description, power)


