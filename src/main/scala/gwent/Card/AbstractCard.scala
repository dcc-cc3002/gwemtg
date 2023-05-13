package cl.uchile.dcc
package gwent.Card

/**
 * AbstractCard
 * esta clase es una representacion de una carta
 * en esta version se encuentra sin implementar excepto por que las cartas tienen nombre
 *
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 2.0.1
 */

import java.util.Objects
import scala.collection.mutable

/** esta clase es una abstraccion de una carta */
abstract class AbstractCard(val nombre: String){
  /** funcion para obtener el nombre */
  def getName: String = nombre
  /** compromiso para funcion para oprobar si dos objetos pueden ser iguales */
  def canEqual(that: Any): Boolean
  /** compromiso para funcion de hash */
  override def hashCode: Int
  /** funcion para comprobar que todos los campos representativos de AbstractCard sean iguales */
  override def equals(ac: Any): Boolean = ac match {
    case ac: Card => ac.canEqual(this) && this.getName == ac.getName && this.## == ac.##
    case _ => false
  }

  /** compromiso para sobreescribir toString */
  override def toString: String
}
