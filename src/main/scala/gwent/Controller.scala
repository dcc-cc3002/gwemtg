package cl.uchile.dcc
package gwent

import gwent.Game
import gwent.Player
import gwent.cards.*
import gwent.board.*

/** Controller
 * Controller is the class that runs the game.
 * It has a game, two players, and a board.
 *
 * It uses the state pattern to run the game,
 * first it starts with the choosing nature of players,
 * in the first implementation it only accepts two robot players or a robot versus a human player.
 * This can easly be extended to accept two human players.
 *
 * Then it runs the game, until it ends, following the rules of the game.
 * The turns are then the following states after the choosing nature of players gives turn to the creation of the decks.
 * After having the decks and before the turns, the decks are shuffled and the game starts.
 * This generates a log of the game, that can be used to replay the game.
 *
 */
class Controller extends App{

}
