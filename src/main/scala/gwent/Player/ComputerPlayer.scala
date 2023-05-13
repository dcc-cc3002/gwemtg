/**
 * ComputerPlayer
 * esta clase representa un jugador automatizado y su comportamiento
 * 
 * 
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.0
 */

package cl.uchile.dcc
package gwent.Player
package gwent.Card

import java.util.Objects


/** este es el constructor de un jugador automata */
class ComputerPlayer(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {

  //documentacion heredada
  override def hashCode: Int = Objects.hash(classOf[ComputerPlayer], name, deck, this.getGems, this.getHand, this.getSide)

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ComputerPlayer]
  /** no es necesario hacer override todavia */
  /*
    override def equals(that: Any): Boolean = that match {
      case cp: ComputerPlayer => cp.canEqual(this) && this.name == cp.name && this.deck == cp.deck && this.getGems == cp.getGems && this.getHand == cp.getHand && this.getSide == cp.getSide && this.## == ap.##
      case _ => false
    }
  */
  override def toString: String = s"ComputerPlayer( nombre=$name, mazo=$deck )"
}
