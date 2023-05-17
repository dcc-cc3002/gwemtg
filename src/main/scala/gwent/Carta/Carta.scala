/**
 * Carta
 * esta clase es una representacion de una carta, instanciable y sin subtipo
 *
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.0
 */

package cl.uchile.dcc
package gwent.Carta

import gwent.Carta.*
import java.util.Objects

/**
 *  este constructor es para tener una carta simplificada para tests
 * la idea es hacer una base de datos de UnitCarta y ClimateCarta tanto para el juego como para los test
 * entonces se puede eliminar Carta que aqui llace
 *
 */
class Carta(nombre: String) extends AbstractCarta(nombre: String){

  /** sobreescribimos hashCode para hacer classOf[Carta] */
  override def hashCode: Int = Objects.hash(classOf[Carta], nombre)
  /** sobreescribimos canEqual para hacer .isInstanceOf[Carta] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Carta]
  /***/
  override def toString: String = s"Carta(nombre=$nombre)"
}


