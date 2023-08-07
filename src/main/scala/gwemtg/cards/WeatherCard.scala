
package cl.uchile.dcc
package gwemtg.cards

import gwemtg.{Game, Player}
import gwemtg.board.*

import java.util.Objects

/** Class representing a weather card in the Gwen't game.
 *
 * A `WeatherCard` is a type of [[Card]] that can be placed in the weather zone.
 * These cards have the ability to affect the battlefield and provide advantages or
 * disadvantages to players, depending on the type of weather that has been chosen.
 *
 * @constructor Creates a new `WeatherCard` with a specified name and description.
 * @param name The name of the card.
 * @param description The description of the card, explaining its specific effects.
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
class WeatherCard(val name: String, val description: String) extends Card with Equals {
  /** The converted mana cost of the card.
   * aka: CMC
   * This shows how much mana is needed to play the card.
   * Climate cards have no mana cost, this means they are free to play.
   */
  private val CMC: Int = 0

  /** Checks if two objects belong to the class WeatherCard */
  def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  /** Getter for the [[name]] of the card.
   *
   * @return The [[name]] of the card.
   */
  override def getName: String = name

  /** Getter for the [[description]] of the card.
   *
   * @return The [[description]] of the card.
   */
  override def getDescription: String = description

  /** getCMC
   * getCMC returns the mana cost of the card
   */
  override def getCMC: Int = {CMC}
  
  /** overwrite equals for WeatherCard */
  override def equals(wc: Any): Boolean = wc match {
    case wc: WeatherCard => wc.canEqual(this) && this.getName == wc.getName && this.getDescription == wc.getDescription
    case _ => false
  }


  /** overwrite hashcode */
  override def hashCode: Int = {
    if this == null then Objects.hash(classOf[WeatherCard], null)
    else Objects.hash(classOf[WeatherCard], name)
  }

  /** getPlayed 
   * tells the zone to be edited after player plays the card with play()
   */
  override def getPlayed(player: Player, game: Game): Unit = {
    /** not the best implementation, but i want to finish the game */
    game.WeatherEffect(this.name, player)
    game.addWC(this)
    player.removeCard(this)
  }


  /** toString
   * returns a string with the info of the card 
   */
  override def toString: String = {"WeatherCard: " + this.name + ", " + this.description}


  /** getPower
   * weather cards have no power
   * thus, it returns 0
   */
  def getPower: Int = 0



}
