/**
 * UnitCarta
 * esta clase es una representacion de una carta de unidad
 * las tropas o unidades son analogas a las criaturas de MTG
 * estas cartas son lanzadas desde la mano a una zona del tablero, alli llacen
 *
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.1
 */

package cl.uchile.dcc
package gwent.Carta

import java.util.Objects

/**
 * este es el constructor de un carta de criatura o 'unidad'
 *
 * tipo esta representado por un entero por mientras
 * definitivamente hay que cambiarlo por subclases
 * 1 => mele
 * 2 => rango
 * 3 => asedio
 *
 * */
class UnitCarta(nombre: String, var fuerza: Int, val tipo: Int, var coste: Int, val efectos: List[String]=List()) extends Carta(nombre: String){

  /** el indice index debe estar entre 1 y 3 */
  //require(0 < tipo)
  //require(tipo < 4)

  /** sobreescribimos hashCode para hacer classOf[UnitCarta] */
  override def hashCode: Int = Objects.hash(classOf[UnitCarta], nombre, fuerza, tipo, coste, efectos)

  /** sobreescribimos canEqual para hacer .isInstanceOf[UnitCarta] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitCarta]

  /** sobreescibimos equals para que compare los parametros nuevos de UnitCarta */
  override def equals(uc: Any): Boolean = uc match {
    case uc: UnitCarta => uc.canEqual(this) && this.getName == uc.getName && this.fuerza == uc.fuerza && this.tipo == uc.tipo  && this.coste == uc.coste && this.efectos == uc.efectos
    case _ => false
  }
  /***/
  override def toString: String = s"UnitCarta(nombre=$nombre)"
}
