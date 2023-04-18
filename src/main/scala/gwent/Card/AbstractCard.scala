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
 * @version 1.1.3
 */

/** esta clase es una abstraccion de una carta */
abstract class AbstractCard{
  def getName(): String
}

/**
 *  este constructor es para tener una carta simplificada para tests
 * la idea es hacer una base de datos de UnitCard y ClimateCard tanto para el juego como para los test
 * entonces se puede eliminar Card que aqui llace
 *
 */


class Card(nombre: String) extends AbstractCard{
  def getName(): String = nombre
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
class UnitCard(nombre: String, var fuerza: Int, val tipo: Int, var coste: Int, val efectos: List[String]=List()) extends AbstractCard{
  /** el indice index debe estar entre 1 y 6 */
  assert {0 < tipo}
  assert {tipo < 4}
  
  def getName(): String = nombre
}

/** este es el constructor de una carta climatica */
class ClimateCard(nombre: String, var coste: Int, val efectos: List[String]) extends AbstractCard{
  def getName(): String = nombre
}
