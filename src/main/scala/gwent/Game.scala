package cl.uchile.dcc
package gwent

import gwent.Player
import gwent.board.*
import gwent.cards.*



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
  def addCCC(card: CloseCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
        board.p1m.data = card :: board.p1m.data
    } else if (player == this.Player2) {
        board.p2m.data = card :: board.p2m.data
    } else {
      throw new Exception("Player not found")
    }
  }


  /** addRCC
   * adds a ranged combat card to the board
   */
  def addRCC(card: RangedCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
      board.p1r.data = card :: board.p1r.data
    } else if (player == this.Player2) {
      board.p2r.data = card :: board.p2r.data
    } else {
      throw new Exception("Player not found")
    }
  }
  /** addSCC
   * adds a siege combat card to the board
   */
  def addSCC(card: SiegeCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
      board.p1s.data = card :: board.p1s.data
    } else if (player == this.Player2) {
      board.p2s.data = card :: board.p2s.data
    } else {
      throw new Exception("Player not found")
    }
  }
  /** addWC
   * swaps the weather card of the board
   */
  def addWC(card: WeatherCard): Unit = {
    board.clima.data = List(card)
  }
}