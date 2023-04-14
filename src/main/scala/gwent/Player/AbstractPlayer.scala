package cl.uchile.dcc
package gwent.Player

import gwent.Card.*

/**
 * AbstractPlayer
 * esta clase es una abstracion de los actores que toman las decisiones en el TCG Gwent
 * a partir de ella se implementan los jugadores humanos Player y npcs ComputerPlayer
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 1.1.2
 */



abstract class AbstractPlayer(val name: String, var deck: List[Card]) {
  /** metodo que anxade la Card carta en la posicion indice
    * arriba del mazo es 0
    * abajo del mazo es deck.length - 1
    * abajo del mazo tambien es -1
    */
  def cardIn(carta: Card, i: Double): Unit = {
    var indice = i.asInstanceOf[Int]
    /***/
    if(i==0){deck = List(carta) ::: deck.drop(0)}else{
      /** poner la carta en una posicion indice */
      if(i>0){deck = deck.take(indice) ::: List(carta) ::: deck.drop(indice)}else{
        /** caso borde i == -1 */
        if(i==(-1).asInstanceOf[Double]){deck = deck.take(deck.length) ::: List(carta)}
        /** pora poner la carta se recorre el mazo desde el final para los Double < 0  */
        else{
          /** indice dentro del rango */
          assert{deck.length >= indice}
          /** indice = i+1 */
          indice = (deck.length.asInstanceOf[Double]+i).asInstanceOf[Int] + 1
          /** caso inverso a i>0 */
          deck = deck.take(indice) ::: List(carta) ::: deck.drop(indice)
        }
      }
    }
  }
  /** funcion draw es analoga a pop y devuelve la carta robada */
  def draw(): Card = {
    /** carta robada */
    val h = deck.head
    /** el mazo pierde la carta superior */
    deck = deck.drop(1)
    /** return innecesario pero por claridad */
    return h
  }
}

/** este es el constructor de un jugador  */
class Player(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {}

/** este es el constructor de un jugador automata */
class ComputerPlayer(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {}