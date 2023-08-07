package cl.uchile.dcc
package gwent

import gwent.cards.*

import java.util.Objects

/** Class representing a player in the Gwen't game.
 *
 * Each player has a name, a gem counter, a deck of cards, and a hand of cards.
 * The deck and hand are private variables, but can be accessed via their corresponding
 * getter methods.
 * We use immutable lists instead of mutable ones to represent the deck and the hand.
 * This is a common practice in functional programming and in Scala in particular.
 * By using immutable data structures, we can avoid potential side effects caused by
 * mutable state and make our code safer and easier to reason about.
 *
 * @constructor Create a new player with a name, gem counter, deck, and hand.
 * @param name The name of the player.
 * @param gemCounter The initial gem count for the player.
 * @param _deck The initial list of cards in the player's deck.
 * @param _hand The initial list of cards in the player's hand.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
class Player(val name: String, var gemCounter: Int, private var _deck: List[Card],
             private var _hand: List[Card], private var _mana_pool: Int = 4) extends Equals {

  /** Accessor method for the player's deck */
  def deck: List[Card] = _deck

  /** Accessor method for the player's hand */
  private def hand: List[Card] = _hand

  /** Accessor method for the player's mana pool */
  def manaPool: Int = _mana_pool

  /** Draws a card from the deck and adds it to the hand.
   *
   * The top card from the deck is removed and added to the player's hand.
   * This method also returns the drawn card.
   *
   * Note: as lists are immutable, when we "remove" a card from the deck or "add" one to
   * the hand, what we're actually doing is creating a new list with the desired contents
   * and reassigning the _deck or _hand variable to this new list.
   *
   * @return The card that was drawn from the deck.
   */
  def drawCard: Card = {
    val card = deck.head
    _deck = deck.tail
    _hand = card :: hand
    card
  }

  /** Shuffles the player's deck.
   *
   * The order of cards in the player's deck is randomized.
   * This is achieved by creating a new, shuffled list and reassigning _deck to it, rather
   * than by modifying the original list.
   */
  def shuffleDeck: Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  /** Checks if two objects are players */
  def canEqual(other: Any): Boolean = other.isInstanceOf[Player]

  /**
   * hashCode
   * hashCode: -> Int
   * crea una llave a partir de algo
   * este algo deberia ser los componentes de player
   */
  override def hashCode: Int = Objects.hash(classOf[Player], name, gemCounter, deck, hand)

  /**
   * equals
   * equals: any -> Boolean
   * verifica si todos los campos son iguales
   */
  override def equals(p: Any): Boolean = p match {
    case p: Player => p.canEqual(this) && this.name == p.name && this.gemCounter == p.gemCounter && this.deck == p.deck && this.hand == p.hand && this.## == p.##
    case _ => false
  }


  /**
   * funcion que pone una carta en el indice i del mazo
   * comienza desde el indice cero en la carta superior del mazo
   * tambien acepta numeros negativos, siendo -1 el fondo del mazo.
   */
  def cardIn(carta: Card, i: Double): Unit = {
    val indice = i.asInstanceOf[Int]

    (i, indice) match {
      case (0, _) =>
        _deck = List(carta) ::: _deck.drop(0)

      case (_, _) if i > 0 =>
        _deck = _deck.take(indice) ::: List(carta) ::: deck.drop(indice)

      case (-1, _) =>
        _deck = this.deck.take(this.deck.length) ::: List(carta)

      case (_, _) if i < -1 =>
        assert(deck.length >= indice)
        val newIndex = (this.deck.length.asInstanceOf[Double] + i).asInstanceOf[Int] + 1
        _deck = this.deck.take(newIndex) ::: List(carta) ::: this.deck.drop(newIndex)
    }
  }

  /** funcion que pone una carta en el mazo y luego revuelve */
  def cardInDeck(carta: Card): Unit = {
    /** pone una carta en el mazo (arriba) */
    cardIn(carta, 0)

    /** baraja */
    this.shuffleDeck
  }

  /** funcion draw es analoga a pop y devuelve la carta robada */
  private def draw: Card = {
    /** carta robada */
    val h = _deck.head

    /** el mazo pierde la carta superior */
    _deck = _deck.drop(1)
    h
  }
  /** getter de la mano */
  def getHand: List[Card] = _hand
  /** getter del mazo */
  def getDeck: List[Card] = _deck

  /**
   * funcion que juega una carta en una partida Game del juego Gwent
   * esta funcion recibe una carta y un objeto Game y, usando double dispatch, 
   * Game llama a board para que board ponga la carta donde corresponda
   */
  def playCard(carta: Card, game: Game): Unit = {
    carta.getPlayed(this, game)
  }

  /**
   * funcion que saca una carta desde la mano del jugador
   */
  def removeCard(carta: Any): Unit = {
   /**
    * la carta se saca de la mano
    * en caso de que existan duplicados, se saca solo el primero
    */
    for (i <- _hand.indices) {
      if (_hand(i) == carta) {
        _hand = _hand.take(i) ::: _hand.drop(i + 1)
        return ()
      }
    }
  }

  /** deckToString
   * function that returns a string with the cards in the deck
   */
  def deckToString: String = {
    var deckString = ""
    val d = this.getDeck
    for (card <- d) {
      deckString += card.toString + " "
    }
    deckString += "\n"
    deckString
  }

  /** drawInitialHand
   *  function that draws a hand of 10 cards
   */
  def drawInitialHand: Unit = {
    for (i <- 0 until 10) {
      val carta: Card = draw()
      _hand = carta :: _hand
    }
  }

  /** draw3
   *  function that draws a hand of 3 cards
   *  used after the first round is done
   */
  def draw3: Unit = {
    for (i <- 0 until 3) {
      val carta: Card = draw()
      _hand = carta :: _hand
    }
  }

  /** handPrint
   * function that prints the hand of the player
   * this can be used with duress effects
   * @return a string with the cards in the hand
   */
  def handPrint: String = {
    var handString = ""
    val h = this.getHand
    var counter = 0
    for (card <- h) {
      handString += s"$counter: " + card.toString + "\n"
      counter += 1
    }
    handString += "\n"
    handString
  }

  /** hasClimate
   * function that checks if the player has a climate card in their hand
   */
  def hasClimate: Boolean = {
    var hasClimate = false
    val h = this.getHand
    for (card <- h) {
      if (card.isInstanceOf[WeatherCard]) {
        hasClimate = true
      }
    }
    hasClimate
  }

  /** loseGem
   * the player loses a gem
   */
  def loseGem: Unit = {this.gemCounter -= 1}
}
