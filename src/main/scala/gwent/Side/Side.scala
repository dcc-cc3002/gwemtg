package cl.uchile.dcc
package gwent.Side

import gwent.Carta.UnitCarta
import gwent.Player.Player
import java.util.Objects

/**
 * Board
 * esta clase representa el lado correspondiente a un jugador del campo de battalla
 * es una tupla de tres listas de cartas
 * el primer elemento es la zona de mele
 * el segundo elemento es la zona de rango
 * el tercer elemento es la zona de asedio
 *
 * @author Hugo Diaz
 * @since 2.1.1
 * @version 2.1.1
 */

class Side(var mele: List[UnitCarta], var rango: List[UnitCarta], var asedio: List[UnitCarta]){

  override def hashCode: Int = Objects.hash(classOf[Side], mele, rango, asedio)
  def canEqual(that: Any): Boolean = that.isInstanceOf[Side]
  override def equals(s: Any): Boolean = s match {
    case s: Side => s.canEqual(this) && this.## == s.## && this.mele == s.mele && this.rango == s.rango && this.asedio == s.asedio
    case _ => false
  }
}
