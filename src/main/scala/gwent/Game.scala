package cl.uchile.dcc
package gwent

import gwent.Player
import gwent.board.*
import gwent.cards.*

import java.util.jar.Attributes.Name


/**
 * A class representing a game of Gwent.
 * @param board The board of the game.
 * @param _player1 The first player of the game.
 * @param _player2 The second player of the game.
 *
 * Here the game is played, the players play their cards and the board is updated
 * here the design pattern observer is used, Board is the observable and Player s are the observers
 * Game, for playing cards, follows the proxy pattern, Game is the proxy and the board is the real subject.
 * 
 * Aswell as the design pattern factory is implemented in Game,
 * to create the decks of the players and the cards.
 *
 */

class Game(val board: Board, private val _player1: Player, private val _player2: Player) {

  private def Player1 = _player1
  private def Player2 = _player2
  
  /** getP1
   * returns the first player
   */
  def getP1: Player = Player1
  /** getP2
   * returns the second player
   */
  def getP2: Player = Player2

  /** addCCC
   * adds a close combat card to the board
   */
  def addCCC(card: CloseCombatCard, player: Player): Unit = 
  {
    if (player == this.Player1) 
    {
        board.p1m.data = card :: board.p1m.data
    } else if (player == this.Player2) 
    {
        board.p2m.data = card :: board.p2m.data
    } 
//    else {throw new Exception("Player not found")}
  }


  /** addRCC
   * adds a ranged combat card to the board
   */
  def addRCC(card: RangedCombatCard, player: Player): Unit = 
  {
    if (player == this.Player1) 
    {
      board.p1r.data = card :: board.p1r.data
    } 
    else if (player == this.Player2) 
    {
      board.p2r.data = card :: board.p2r.data
    } 
//    else {throw new Exception("Player not found")}
  }
  /** addSCC
   * adds a siege combat card to the board
   */
  def addSCC(card: SiegeCombatCard, player: Player): Unit = 
  {
    if (player == this.Player1) 
    {
      board.p1s.data = card :: board.p1s.data
    } else if (player == this.Player2) 
    {
      board.p2s.data = card :: board.p2s.data
    }
//    else {throw new Exception("Player not found")}
  }
  /** addWC
   * swaps the weather card of the board
   */
  def addWC(card: WeatherCard): Unit = 
  {
    board.clima.data = List(card)
  }

  /** potentialPoints
   * potentialPoints returns the potential points of a player,
   * found by adding the power of all the cards in a player's hand and its board
   */
  def potentialPoints(player: Player): Int = 
  {
    var counter: Int = 0
    if (player == this.Player1) 
    {
      counter += boardPoints(player)
      counter += handPoints(player)
    } else if (player == this.Player2) 
    {
      counter += boardPoints(player)
      counter += handPoints(player)
    }
//    else {throw new Exception("Player not found")}
    counter
  }

  /** boardPoints
   * boardPoints returns the public points of a player, found in the board
   */
  def boardPoints(player: Player): Int = 
  {
    var counter: Int = 0
    if (player == this.Player1) 
    {
      for (card <- board.p1m.data) 
      {
        counter += card.getPower
      }
      for (card <- board.p1r.data) 
      {
        counter += card.getPower
      }
      for (card <- board.p1s.data) 
      {
        counter += card.getPower
      }
    } else if (player == this.Player2) 
    {
      for (card <- board.p2m.data) 
      {
        counter += card.getPower
      }
      for (card <- board.p2r.data) 
      {
        counter += card.getPower
      }
      for (card <- board.p2s.data) 
      {
        counter += card.getPower
      }
    }
//    else {throw new Exception("Player not found")}
    counter
  }

  /** handPoints
   * handPoints returns the points of a player's hand
   */
  def handPoints(player: Player): Int = {
    var counter: Int = 0
    if player == this.Player1 then for (card <- player.getHand) counter = counter + card.getPower
    else if player == this.Player2 then for (card <- player.getHand) counter = counter + card.getPower
//    else {throw new Exception("Player not found")}
    counter
  }

  /** nextRound
   * function that calculates the power of the sides of the board
   * after determining the winner of the round, the board is reset
   * the loser of the round loses a gem
   * in case of a tie, both players lose a gem
   */
  def nextRound(): Int = {
    var i: Int = -1
    if(this.boardPoints(this.Player1) == this.boardPoints(this.Player2)){
      this.Player1.loseGem()
      this.Player2.loseGem()
      i = 0
    } else if(this.boardPoints(this.Player1) > this.boardPoints(this.Player2)){
      this.Player2.loseGem()
      i = 1
    } else if (this.boardPoints(this.Player1) < this.boardPoints(this.Player2)) {
      this.Player1.loseGem()
      i = 2
    }
//    else {throw new Exception("Error in nextRound")}
    this.board.reset()
    this.getP1.draw3()
    this.getP2.draw3()
    i
//    else {throw new Exception("Error in nextRound")}
  }


  /*** RangedCombatCardEffect
   * function that applies the effect of a ranged combat card
   * there are 3 possible effects:
   * refuerzo_moral: adds 1 power to all other cards in the same row
   * vinculo_estrecho: duplicates the power of any card in the same row with the same name
   * vainilla: no effect
   */
  def RangedCombatCardEffect(cartita: Card, p: Player): Unit = {
    val name = cartita.description
    name match
      case "refuerzo_moral" =>
        if p == this.Player1 then for(card <- board.p1r.data){card.setPower(card.getPower + 1)}
        else if p == this.Player2 then for(card <- board.p2r.data){card.setPower(card.getPower + 1)}
      
      case "vinculo_estrecho" =>
        if (p == this.Player1) {
          for (card <- board.p1r.data) {
            if (card.getName == cartita.getName) {
              card.setPower(card.getPower * 2)
            }
          }
        } else if (p == this.Player2) {
          for (card <- board.p2r.data) {
            if (card.getName == cartita.getName) {
              card.setPower(card.getPower * 2)
            }
          }
        } 
      
      case _ => 
  }

  /** CloseCombatCardEffect
   * function that applies the effect of a close combat card
   * there are 3 possible effects:
   * refuerzo_moral: adds 1 power to all other cards in the same row
   * vinculo_estrecho: duplicates the power of any card in the same row with the same name
   * vainilla: no effect
   */
  def CloseCombatCardEffect(cartita: Card, p: Player): Unit = {
    val name = cartita.description
    name match
      case "refuerzo_moral" => 
        if p == this.Player1 then for (card <- this.board.p1m.data) {
          card.setPower(card.getPower + 1)
        }
        else if p == this.Player2 then for (card <- this.board.p1m.data) {
          card.setPower(card.getPower + 1)
        }

      
      case "vinculo_estrecho" => 
        if (p == this.Player1) {
          for (card <- board.p1m.data) {
            if (card.getName == cartita.getName) {
              card.setPower(card.getPower * 2)
            }
          }
        } else if (p == this.Player2) {
          for (card <- board.p1m.data) {
            if (card.getName == cartita.getName) {
              card.setPower(card.getPower * 2)
            }
          }
        }
      case _ => 
  }

  /** SiegeCombatCardEffect
   * function that applies the effect of a siege combat card
   * there are 3 possible effects:
   * refuerzo_moral: adds 1 power to all other cards in the same row
   * vinculo_estrecho: duplicates the power of any card in the same row with the same name
   * vainilla: no effect
   */
  def SiegeCombatCardEffect(cartita: Card, p: Player): Unit = {
    val name = cartita.description
    name match
      case "refuerzo_moral" => 
        if p == this.Player1 then for (card <- this.board.p1s.data) {
          card.setPower(card.getPower + 1)
        }
        else if p == this.Player2 then for (card <- this.board.p1s.data) {
          card.setPower(card.getPower + 1)
        }

      
      case "vinculo_estrecho" => 
        if (p == this.Player1) {
          for (card <- board.p1s.data) {
            if (card.getName == cartita.getName) {
              card.setPower(card.getPower * 2)
            }
          }
        } else if (p == this.Player2) {
          for (card <- board.p1s.data) {
            if (card.getName == cartita.getName) {
              card.setPower(card.getPower * 2)
            }
          }
        } 

      
      case _ => 
  }

  /** WeatherEffect
   * WeatherEffect is a function that applies the effect of a weather card
   * there are 5 possible effects:
   * "Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de melee a 1"
   * "Niebla Impenetrable", "Convierte el valor de fuerza de todas las cartas de rango a 1."
   * "LLuvia Torrencial", "Convierte el valor de fuerza de todas las cartas de asedio a 1."
   * "Despejar", "Limpia todos los efectos de clima del campo de batalla."
   * "Cuerno del Comandante", "Dobla la fuerza de todas las unidades de una fila propia al azar."
   *
   * because every card has a different effect, we will use name as id instead of description
   */
  def WeatherEffect(n: String, p: Player) : Unit = {
    n match
      case "Escarcha mordiente" => 
        for (card <- this.board.p1m.data) {card.setPower(1)}
        for (card <- this.board.p2m.data) {card.setPower(1)}
      
      case "Niebla Impenetrable" => 
         for (card <- this.board.p1r.data) {card.setPower(1)}
         for (card <- this.board.p2r.data) {card.setPower(1)}
      
      case "LLuvia Torrencial" => 
        for (card <- this.board.p1s.data) {card.setPower(1)}
        for (card <- this.board.p2s.data) {card.setPower(1)}
      case "Despejar" => 
        for(card <- this.board.p1m.data){card.setPower(card.getOGPower)}
        for(card <- this.board.p1r.data){card.setPower(card.getOGPower)}
        for(card <- this.board.p1s.data){card.setPower(card.getOGPower)}
        for(card <- this.board.p2m.data){card.setPower(card.getOGPower)}
        for(card <- this.board.p2r.data){card.setPower(card.getOGPower)}
        for(card <- this.board.p2s.data){card.setPower(card.getOGPower)}
      case "Cuerno del Comandante" =>
        if (p == this.Player1){
          var rand = new scala.util.Random
          var row = rand.nextInt(3)
          row match
            case 0 => for(card <- this.board.p1m.data){card.setPower(card.getPower * 2)}
            case 1 => for(card <- this.board.p1r.data){card.setPower(card.getPower * 2)}
            case 2 => for(card <- this.board.p1s.data){card.setPower(card.getPower * 2)}
        }
        else if(p == this.Player2){
          var rand = new scala.util.Random
          var row = rand.nextInt(3)
          row match
            case 0 => for (card <- this.board.p2m.data) {card.setPower(card.getPower * 2)}
            case 1 => for (card <- this.board.p2r.data) {card.setPower(card.getPower * 2)}
            case 2 => for (card <- this.board.p2s.data) {card.setPower(card.getPower * 2)}}
      case _ => 
  }
}