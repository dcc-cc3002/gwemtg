/**
 * ClimateCarta
 * esta clase es una representacion de una carta de clima
 * estas cartas afectan una zona completa del tablero o varias
 *
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.0
 */

package cl.uchile.dcc
package gwent.Carta


import java.util.Objects

/** este es el constructor de una carta climatica */
class ClimateCarta(nombre: String, var coste: Int, val efectos: List[String]) extends Carta(nombre: String){

  /** sobreescribimos hashCode para hacer classOf[ClimateCarta] */
  override def hashCode: Int = Objects.hash(classOf[ClimateCarta], nombre, coste, efectos)

  /** sobreescribimos canEqual para hacer .isInstanceOf[ClimateCarta] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ClimateCarta]

  /** sobreescibimos equals para que compare los parametros nuevos de ClimateCarta */
  override def equals(cc: Any): Boolean = cc match {
    case cc: ClimateCarta => cc.canEqual(this) && this.getName == cc.getName && this.coste == cc.coste && this.efectos == cc.efectos
    case _ => false
  }

  /** */
  override def toString: String = s"ClimateCarta(nombre=$nombre)"
}
