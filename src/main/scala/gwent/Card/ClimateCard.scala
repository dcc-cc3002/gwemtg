/**
 * ClimateCard
 * esta clase es una representacion de una carta de clima
 * estas cartas afectan una zona completa del tablero o varias
 *
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.0
 */

package cl.uchile.dcc
package gwent.Card


/** este es el constructor de una carta climatica */
class ClimateCard(nombre: String, var coste: Int, val efectos: List[String]) extends Card(nombre: String){

  /** sobreescribimos hashCode para hacer classOf[ClimateCard] */
  override def hashCode: Int = Objects.hash(classOf[ClimateCard], nombre, coste, efectos)

  /** sobreescribimos canEqual para hacer .isInstanceOf[ClimateCard] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ClimateCard]

  /** sobreescibimos equals para que compare los parametros nuevos de ClimateCard */
  override def equals(cc: Any): Boolean = cc match {
    case cc: ClimateCard => cc.canEqual(this) && this.getName == cc.getName && this.coste == cc.coste && this.efectos == cc.efectos
    case _ => false
  }

  /** */
  override def toString: String = s"ClimateCard(nombre=$nombre)"
}
