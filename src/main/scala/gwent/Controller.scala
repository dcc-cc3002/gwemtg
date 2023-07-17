package cl.uchile.dcc
package gwent

import gwent.Game
import gwent.Player
import gwent.DeckBuilder
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
object Controller extends App {
  println("Enter your user name: ")
  val PlayerName = scala.io.StdIn.readLine()
  println(s"$PlayerName, here are the playing options:")
  println("1 Play against the computer")
  println("2 Watch a game between two computers")
  println("please enter your choice (1/2): ")
  var choice = scala.io.StdIn.readLine()
  if (choice != "1" && choice != "2") {
    println("Invalid choice, please enter 1 or 2: ")
    val choice = scala.io.StdIn.readInt()
  }
  else if (choice == "1") {
    val deckbuilder: DeckBuilder = new DeckBuilder()
    val deckPlayer1: List[Card] = deckbuilder.buildDeck()
    val deckPlayer2: List[Card] = deckbuilder.buildDeck()
    println(deckPlayer1)
    println(deckPlayer2)
    var human: Player = new Player(PlayerName, 2, deckPlayer1, List())
    var robot: Player = new Player("Robot", 2, deckPlayer2, List())
  }
}
