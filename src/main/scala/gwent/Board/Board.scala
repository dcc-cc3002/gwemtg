package cl.uchile.dcc
package gwent.Board

import gwent.Carta.{Carta, ClimateCarta}
import gwent.Side.Side
import java.util.Objects

/**
 * Board
 * esta clase representa el campo de battalla
 * es una tupla de dos Side objects y una ClimateCarta, que va al medio 
 *
 * @author Hugo Diaz
 * @since 2.1.1
 * @version 2.1.1
 */

class Board(var player1: Side, var clima: ClimateCarta, var player2: Side) {
  override def hashCode: Int = Objects.hash(classOf[Board], player1, clima, player2)

  def canEqual(that: Any): Boolean = that.isInstanceOf[Board]

  override def equals(b: Any): Boolean = b match {
    case b: Board => b.canEqual(this) && this.## == b.## && this.player1 == b.player1 && this.clima == b.clima && this.player2 == b.player2
    case _ => false
  }
}
