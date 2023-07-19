package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.*

/** Trait representing no effect
 *
 * It has a override metho for getPlayed 
 * the method is used to excecute nothing
 * prints " " then get the card played
 */
trait vainilla extends AbstractUnitCard
{
  /** do nothing */
  override def getPlayed(): Unit = {
    println(" ")
    getPlayed()
  }
}
