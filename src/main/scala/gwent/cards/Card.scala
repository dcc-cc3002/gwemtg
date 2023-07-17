
package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.{Game, Player}
import cl.uchile.dcc.gwent.board.Board

import java.util.Objects
import scala.collection.mutable


/** Trait representing a card in the Gwen't game.
 *
 * A card is characterized by its [[name]] and [[description]].
 * This trait serves as a common interface for all card types and ensures that every card,
 * regardless of its specific subtype, will have these basic properties.
 *
 * The ``val`` keyword in the property declarations indicates that these properties are
 * immutable -- once a card has been created with a certain name and description, these
 * cannot be changed.
 * This reflects the real-world behaviour of game cards, which have fixed names and
 * descriptions printed on them.
 *
 * The actual content of these properties, as well as any additional properties or
 * behaviours, are to be defined in the concrete classes that extend this trait.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
trait Card {

  /** The name of the card.
   * This is an immutable property.
   */
  val name: String

  /** A description of the card's properties or effects.
   * This is an immutable property.
   */
  val description: String
  
  /** getPlayed
   * A function that puts a card into the board according to the rules of the game.
   * The card must be placed in a zone of the board that is owned by the player playing the card,
   * in case of being a climate card, it is placed in the common weather zone.
   * 
   * Here we use double dispatch where the player is the one who calls the function and the board is the observed object.
   */
  def getPlayed(player: Player, game: Game): Unit
  /** toString 
   * function that returns a string with the information of the card.
   * this function is used to print the card in the console for playing players to see.
   */
  def toString: String
}
