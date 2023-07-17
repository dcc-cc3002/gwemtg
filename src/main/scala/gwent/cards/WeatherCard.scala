
package cl.uchile.dcc
package gwent.cards

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
  /** Checks if two objects belong to the class WeatherCard */
  def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  /** Getter for the [[name]] of the card.
   *
   * @return The [[name]] of the card.
   */
  def getName: String = name

  /** Getter for the [[description]] of the card.
   *
   * @return The [[description]] of the card.
   */
  def getDescription: String = description

 
  
  /** overwrite equals for WeatherCard */
  override def equals(wc: Any): Boolean = wc match {
    case wc: WeatherCard => wc.canEqual(this) && this.getName == wc.getName && this.getDescription == wc.getDescription
    case _ => false
  }

  /** overwrite hashcode */

  /** overwrite hashcode */
  override def hashCode: Int = {
    if this == null then return Objects.hash(classOf[WeatherCard], null)
    else return Objects.hash(classOf[WeatherCard], name)
  }
}
