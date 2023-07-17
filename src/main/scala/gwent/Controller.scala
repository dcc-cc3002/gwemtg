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
  var log: List[String] = List()
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
    /** we show the deck of the human player */
    println("Your deck is: ")
    println(deckPlayer1)
    var human: Player = new Player(PlayerName, 2, deckPlayer1, List())
    var robot: Player = new Player("Robot", 2, deckPlayer2, List())
    /** we register name of players */
    log = log :+ "Player 1: " + human.name + "\n"
    log = log :+ "Player 2: " + robot.name + "\n"
    /** we register the decks of players */
    log = log :+ "Player 1 deck: " + human.deckToString + "\n"
    log = log :+ "Player 2 deck: " + robot.deckToString + "\n"
    /** we shuffle the decks and draw the hands*/
    human.shuffleDeck()
    robot.shuffleDeck()
    human.drawInitialHand()
    robot.drawInitialHand()
    /** we show the hand of the human player */
    println("Your hand is: ")
    println(human.handPrint)
//    println(human.getHand)
    /** we register the hands of players */
    log = log :+ "Player 1 hand: " + human.hand + "\n"
    log = log :+ "Player 2 hand: " + robot.hand + "\n"
    /** we create the board, empty */
    var tablero: Board = new Board()
    /** we create the match */
    var partida: Game = new Game(tablero, human, robot)

    /** we give the player a brief rules debrief and start the game */
    println("The rules of the game are the following: ")
    println("You can play a card from your hand, or pass your turn.")
    println("You can only play one card per turn.")
    println("You can only play a card if you have enough mana.")
    println("The game ends when a player or both players die.")
    println("If both players die, the game is a draw.")
    println()
    println("The game is played in rounds.")
    println("In each round, the players play cards until both pass.")
    println("The player with the highest total strength wins the round.")
    println("The losers of the round lose a gem.")
    println("A player dies if they lose all their gems.")
    println("After a round ends, if there is more than a player alive, the players draw three cards.")
    println()
    println("The game is starting now, good luck.")
    println()
    println("Here is the board:")
    println(tablero)
    println("Here is your hand, you can play a card by choosing a number.")
  }
}
