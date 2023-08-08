package hugodiazroa
package gwemtg

import gwemtg.Player
import gwemtg.board.*
import gwemtg.cards.*


/**
 * A class representing a game of Gwent.
 * this abstraction acomplishes the role of an observer
 * in the design pattern observer, the players are the observable
 * they notify the game when they die, when the state is triggered
 * the players die  when their gems are 0
 *
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

  var killed: List[Player] = List()

  /** getP1
   * returns the first player
   */
  def getP1: Player = Player1
  /** getP2
   * returns the second player
   */
  def getP2: Player = Player2
  /** getBoard
   * returns the board
   */
  def getBoard: Board = board

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
    //else {throw new Exception("Player not found")}
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
    //else {throw new Exception("Player not found")}
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
    //else {throw new Exception("Player not found")}
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
    } else if (player == this.Player2) {
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

  /**
   * deadPlayers
   * add dead players to killed list
   */
  def deadPlayers(p: Player): Unit ={
    this.killed = List(p) ::: this.killed
  }
}