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
 * @version 1.1.2
 */

abstract class AbstractCard(val nombre: String) {

}

class Card(nombre: String) extends AbstractCard(nombre: String){}

/** este es el constructor de un carta de criatura o 'unidad' */
class UnitCard(nombre: String, var fuerza: Int, val tipo: String, var coste: Int, val efectos: List[String]) extends AbstractCard(nombre: String){

}


/** este es el constructor de una carta climatica */
class ClimateCard(nombre: String, var coste: Int, val efectos: List[String]) extends AbstractCard(nombre: String) {


}