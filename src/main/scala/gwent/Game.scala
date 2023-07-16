
package cl.uchile.dcc
package gwent

import gwent.*

import gwent.board.Board

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

class Game(val board: Board, val player1: Player, val player2: Player){
  
}
