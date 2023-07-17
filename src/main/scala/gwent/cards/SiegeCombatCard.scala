
package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.{Game, Player}
import cl.uchile.dcc.gwent.board.Board

import java.util.Objects

/** Class representing a siege combat unit card in the Gwen't game.
 *
 * A `SiegeCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent siege machinery used on the battlefield.
 * As per the game's rules, these cards can only be placed in the siege combat zone.
 *
 * @constructor create a new siege combat card with name, description, and power.
 * @param name the name of the card.
 * @param description the description of the card.
 * @param power the initial power value of the card, which also corresponds to the siege
 *              machinery's strength.
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
class SiegeCombatCard(name: String, description: String, power: Int)
  extends AbstractUnitCard(name, description, power){

  /** Checks if two objects belong to the class SiegeCombatCard */
  def canEqual(other: Any): Boolean = other.isInstanceOf[SiegeCombatCard]


  /** overwrite equals for CloseCombatCard */
  override def equals(scc: Any): Boolean = scc match {
    case scc: SiegeCombatCard => scc.canEqual(this) && this.getName == scc.getName && this.getDescription == scc.getDescription && this.getPower == scc.getPower
    case _ => false
  }

  /** overwrite hashcode */
  override def hashCode: Int = {
    if this == null then return Objects.hash(classOf[SiegeCombatCard], null)
    else return Objects.hash(classOf[SiegeCombatCard], name)
  }

  /** getPlayed 
   * tells the zone to be edited after player plays the card with play()
   */
  override def getPlayed(player: Player, game: Game): Unit = {
    game.addSCC(this, player)
    player.removeCard(this)
  }
}

