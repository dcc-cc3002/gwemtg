package cl.uchile.dcc
package gwent.Card

/**
 * Card
 * esta clase es una representacion de una carta
 * en esta version se encuentra sin implementar excepto por que las cartas tienen nombre
 *
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 2.0.0
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
class UnitCard(nombre: String, var fuerza: Int, val tipo: Int, var coste: Int, val efectos: List[String]=List()) extends Card(nombre: String){

  /** el indice index debe estar entre 1 y 3 */
  //assert(0 < tipo)
  //assert(tipo < 4)

  /** sobreescribimos hashCode para hacer classOf[UnitCard] */
  override def hashCode: Int = Objects.hash(classOf[UnitCard], nombre, fuerza, tipo, coste, efectos)

  /** sobreescribimos canEqual para hacer .isInstanceOf[UnitCard] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitCard]

  /** sobreescibimos equals para que compare los parametros nuevos de UnitCard */
  override def equals(uc: Any): Boolean = uc match {
    case uc: UnitCard => uc.canEqual(this) && this.getName == uc.getName && this.fuerza == uc.fuerza && this.tipo == uc.tipo  && this.coste == uc.coste && this.efectos == uc.efectos
    case _ => false
  }
  /***/
  override def toString: String = s"UnitCard(nombre=$nombre)"
}

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
