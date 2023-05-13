/**
 * Card
 * esta clase es una representacion de una carta, instanciable y sin subtipo
 *
 * @author Hugo Diaz
 * @since 2.0.1
 * @version 2.1.0
 */

package cl.uchile.dcc
package gwent.Card

import Card._
import java.util.Objects

/**
 *  este constructor es para tener una carta simplificada para tests
 * la idea es hacer una base de datos de UnitCard y ClimateCard tanto para el juego como para los test
 * entonces se puede eliminar Card que aqui llace
 *
 */
class Card(nombre: String) extends AbstractCard(nombre: String){

  /** sobreescribimos hashCode para hacer classOf[Card] */
  override def hashCode: Int = Objects.hash(classOf[Card], nombre)
  /** sobreescribimos canEqual para hacer .isInstanceOf[Card] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Card]
  /***/
  override def toString: String = s"Card(nombre=$nombre)"
}


