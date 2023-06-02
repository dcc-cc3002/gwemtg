
package cl.uchile.dcc
package gwent.cards

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
class SiegeCombatCard(name: String, cost: Int, power: Int)
  extends AbstractUnitCard(name, cost, power)

