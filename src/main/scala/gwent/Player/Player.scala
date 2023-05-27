/**
 * Player
 * esta clase representa un jugador humano y su comportamiento
 *
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.1
 */

package cl.uchile.dcc
package gwent
package Player

import cl.uchile.dcc.gwent.Carta.Carta
import java.util.Objects


/** este es el constructor de un jugador  */
class Player(name: String, deck: List[Carta]) extends AbstractPlayer(name, deck) {
  //documentacion heredada
  override def hashCode: Int = Objects.hash(classOf[Player], name, deck, this.getGems, this.getHand, this.getSide)
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  /** no es necesario hacer override todavia */
  /*
    override def equals(that: Any): Boolean = that match {
      case p: Player => p.canEqual(this) && this.name == p.name && this.deck == p.deck && this.getGems == p.getGems && this.getHand == p.getHand && this.getSide == p.getSide && this.## == ap.##
      case _ => false
    }
  */


  override def toString: String = s"Player( nombre=$name, mazo=$deck )"
}

