
package cl.uchile.dcc
package gwent

import gwent.*
import gwent.board.*
import gwent.cards.{Card, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

/**
 * A class representing a game of Gwent.
 * @param board The board of the game.
 * @param player1 The first player of the game.
 * @param player2 The second player of the game.
 *
 * here the game is played, the players play their cards and the board is updated
 * here the design pattern observer is used, the board is the observable and the players are the observers
 * aswell as the design pattern factory is implemented here to create the decks of the players and the cards
 *
 */

class Game(val board: Board, private val _player1: Player, private val _player2: Player) {

  def Player1 = _player1
  def Player2 = _player2

  /** addCCC
   * adds a close combat card to the board
   */
  def addCCC(card: CloseCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
        board.add(card, board.p1s)
      }
      else {
        board.add(card, board.p2s)
    }
  }

  /** addRCC
   * adds a ranged combat card to the board
   */
  def addRCC(card: RangedCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
      board.add(card, board.p1s)
    }
    else {
      board.add(card, board.p2s)
    }
  }
  /** addSCC
   * adds a siege combat card to the board
   */
  def addSCC(card: SiegeCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
      board.add(card, board.p1s)
    }
    else {
      board.add(card, board.p2s)
    }
  }
  /** addWC
   * swaps the weather card of the board
   */
  def addWC(card: WeatherCard): Unit = {
    board.clima.data = List(card)
  }
}