package cl.uchile.dcc
package gwent.Player

import gwent.Player.*
import gwent.Card.*
import java.util.Objects

/**
 * AbstractPlayer
 * esta clase es una abstracion de los actores que toman las decisiones en el TCG Gwent
 * a partir de ella se implementan los jugadores humanos Player y npcs ComputerPlayer
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 1.1.3
 */



/**
 * Represents an abstract player in the Gwent game.
 * This class serves as a base for both human players (Player) and non-player characters (ComputerPlayer).
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 1.1.3
 */
abstract class AbstractPlayer(val name: String, var deck: List[Card]) {
  /**
   * side representa el lado del tablero poseido por un jugador
   * su tipo es Tuple(List[Card],List[Card],List[Card])
   * */
  var side = (List[Card],List[Card],List[Card])
  /** hand representa la mano de cartas de un jugador */
  var hand : List[Card] = List()
  /** gems representa las vidas del jugador, llamadas gemas */
  var gems : Int = 2
  /** initialDeckSize es una constante, 25, que es el unico valor valido para el larrgo de una mazo */
  val initialDeckSize: Int = 25

  /**
   * hashCode
   * hashCode: ???
   * crea una llave a partir de algo, por ser remplazada a por la del auxiliar
   */
  override def hashCode: Int = Objects.hash(classOf[AbstractPlayer], side, hand, gems)
  /** verificamos que initialDeckSize sea 25 */
  assert {
    initialDeckSize == 25
  }

  /**
   * canEqual
   * canEqual: any -> Boolean
   * verifica si se puede comparar dos objetos al poder ser instanciado como la clase AbstractPlayer
   *
   * definida aqui
   */
  def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractPlayer]

  /**
   * equals
   * equals: any -> Boolean
   * verifica si todos los campos
   */
  override def equals(that: Any): Boolean = that match {
    case ap: AbstractPlayer => ap.canEqual(this) &&  this.side == ap.side && this.hand == ap.hand && this.gems == ap.gems && this.initialDeckSize == ap.initialDeckSize && ap.initialDeckSize == 25
    case _ => false
  }


  /**  */
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

  /**
   * metodo que representa jugar una carta
   *
   * la indexacion es la siguiente
   * 1 propio asedio
   * 2 pripio rango
   * 3 propio mele
   * 4 contrario mele
   * 5 contrario rango
   * 6 contrario asedio
   *
   */

  def play(card: Card, index: Int): Unit ={
    /** el indice index debe estar entre 1 y 6 */
    assert{0 < index}
    assert{index < 7}
    /** el tipo de card debe poder lanzarse a la zona en la zona que representa index */
    //do stuff
  }
}

/** este es el constructor de un jugador  */
class Player(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {}

/** este es el constructor de un jugador automata */
class ComputerPlayer(name: String, deck: List[Card]) extends AbstractPlayer(name, deck) {}