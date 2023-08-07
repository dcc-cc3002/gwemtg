
package cl.uchile.dcc
package gwemtg
package cards

import cl.uchile.dcc.gwemtg.{Game, Player}
import cl.uchile.dcc.gwemtg.board.Board

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
class SiegeCombatCard(name: String, description: String, power: Int, cmc: Int)
  extends AbstractUnitCard(name, description, power){


  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  private var currentPower: Int = power

  /** The original power of the card, which is used to reset the current power of the card
   * this is what would be printed on the card in a physical game.
   */
  private val originalPower: Int = power

  /** The converted mana cost of the card.
   * aka: CMC
   * This shows how much mana is needed to play the card.
   */
  private val CMC: Int = cmc

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
    /** not the best implementation, but i want to finish the game */
    game.SiegeCombatCardEffect(this, player)
    game.addSCC(this, player)
    player.removeCard(this)
  }


  /** toString
   * returns a string with the info of the card 
   */
  override def toString: String = {"SiegeCombatCard: " + this.getName + ", " + this.getDescription + ", " + this.getPower}

  /** getPower
   * getPower returns the power of the card
   */
  override def getPower: Int = {currentPower}

  /** getName
   * getName returns the name of the card
   */
  override def getName: String = {name}

  /** getCMC
   * getCMC returns the mana cost of the card
   */
  override def getCMC: Int = {CMC}

  /** setPower  
   * setPower is a setter function for the currentPower of the card.
   */
  def setPower(newPower: Int): Unit = {
    currentPower = newPower
  }

  /** Getter for the [[originalPower]] of the card.
   *
   * @return The [[originalPower]] of the card.
   */
  def getOGPower: Int = originalPower


  /** Getter for the [[description]] of the card. */
  def getDescription: String = description

}

