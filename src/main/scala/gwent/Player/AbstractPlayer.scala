package cl.uchile.dcc
package gwent.Player

import gwent.Card.Card

/**
 * AbstractPlayer
 * esta clase es una abstracion de los actores que toman las decisiones en el TCG Gwent
 * a partir de ella se implementan los jugadores humanos Player y npcs ComputerPlayer
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 1.1.0
 */
abstract class AbstractPlayer(val name: String, var deck: List[Card]) {
  /** metodo que anxade la Card carta en la posicion indice
    * arriba del mazo es 0
    * abajo del mazo es deck.length - 1
    * abajo del mazo tambien es -1
    */
  def cardIn(carta: Card, i: Double): Unit = {
    val indice = i.asInstanceOf[Int]
    /***/
    if(i==0){deck = List(carta) ::: deck.drop(0)}
    /**poner la carta en una posicion indice*/  
    else{if(i>0){deck = deck.take(indice-1) ::: List(carta) ::: deck.drop(indice)}
    //else{if(i==-1){deck = deck.take(deck.length) ::: List(carta)}
    /**pora poner la carta se recorre el mazo desde el final para los Double < 0  */
    else{deck = deck.take(deck.length-indice) ::: List(carta) ::: deck.drop(1+deck.length-indice)}}
  }

  def draw(): Card = {
    val h = deck.head
    deck = deck.drop(1)
    return h
  }
}

//este es el constructor de un jugador humano
class Player(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {

}

//este es el constructor de un jugador automata
class ComputerPlayer(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {

}