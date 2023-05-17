package cl.uchile.dcc
package gwent.Carta

/**
 * AbstractCarta
 * esta clase es una representacion de una carta
 * en esta version se encuentra sin implementar excepto por que las cartas tienen nombre
 *
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 2.1.1
 */


import java.util.Objects
import scala.collection.mutable

/** esta clase es una abstraccion de una carta */
abstract class AbstractCarta(val nombre: String){
  /** funcion para obtener el nombre */
  def getName: String = nombre
  /** compromiso para funcion para oprobar si dos objetos pueden ser iguales */
  def canEqual(that: Any): Boolean
  /** compromiso para funcion de hash */
  override def hashCode: Int
  /** funcion para comprobar que todos los campos representativos de AbstractCarta sean iguales */
  override def equals(ac: Any): Boolean = ac match {
    case ac: AbstractCarta => ac.canEqual(this) && this.getName == ac.getName && this.## == ac.##
    case _ => false
  }

  /** compromiso para sobreescribir toString */
  override def toString: String
}
