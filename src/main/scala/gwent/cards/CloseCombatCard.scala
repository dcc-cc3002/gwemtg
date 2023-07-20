
package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.{Game, Player}
import cl.uchile.dcc.gwent.board.Board

import java.util.Objects

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
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
class CloseCombatCard(name: String, description: String, power: Int) extends AbstractUnitCard(name, description, power) {
  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  private var currentPower: Int = power

  /** The original power of the card, which is used to reset the current power of the card
   * this is what would be printed on the card in a physical game.
   */
  private val originalPower: Int = power
  /** Checks if two objects belong to the class CloseCombatCard */
  def canEqual(other: Any): Boolean = other.isInstanceOf[CloseCombatCard]

  /** overwrite equals for CloseCombatCard */
  override def equals(ccc: Any): Boolean = ccc match {
    case ccc: CloseCombatCard => ccc.canEqual(this) && this.getName == ccc.getName 
    case _ => false
  }

  /** overwrite hashcode */
  override def hashCode: Int = {
    if this == null then return Objects.hash(classOf[CloseCombatCard], null)
    else return Objects.hash(classOf[CloseCombatCard], name)
  }

  /** getPlayed 
   * tells the zone to be edited after player plays the card with play()
   */
  override def getPlayed(player: Player, game: Game): Unit = {
    /** not the best implementation, but i want to finish the game */
    game.CloseCombatCardEffect(this.description, player)
    game.addCCC(this, player)
    player.removeCard(this)
  }
  
  /** toString
   * returns a string with the info of the card 
   */
  override def toString: String = {"CloseCombatCard: " + this.getName + ", " + this.getDescription + ", " + this.getPower}

  /** getPower
   * getPower returns the power of the card
   */
  override def getPower: Int = {currentPower}

  /** getName
   * getName returns the name of the card
   */
  override def getName: String = {name}
  

}


