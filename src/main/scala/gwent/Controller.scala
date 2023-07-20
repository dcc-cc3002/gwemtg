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
  val rand = new scala.util.Random
  private var log: List[String] = List()
  private var pasado: Boolean = false
  println("Enter your user name: ")
  private val PlayerName = scala.io.StdIn.readLine()

  /** we create the deckbuilder and the decks of the players */
  private val deckbuilder: DeckBuilder = new DeckBuilder()

  /** we build the decks */
  private val deckPlayer1: List[Card] = deckbuilder.buildDeck()
  private val deckPlayer2: List[Card] = deckbuilder.buildDeck()

  /** we show the deck of the human player */
  println("Your deck is: ")
  println(deckPlayer1)
  private var human: Player = new Player(PlayerName, 2, deckPlayer1, List())
  private var robot: Player = new Player("Robot", 2, deckPlayer2, List())

  /** we register name of players */
  log = log :+ "Player 1: " + human.name + "\n"
  log = log :+ "Player 2: " + robot.name + "\n"

  /** we register the decks of players */
  log = log :+ "Player 1 deck: " + human.deckToString + "\n"
  log = log :+ "Player 2 deck: " + robot.deckToString + "\n"

  /** we shuffle the decks and draw the hands */
  human.shuffleDeck()
  robot.shuffleDeck()
  human.drawInitialHand()
  robot.drawInitialHand()

  /** we show the hand of the human player */
  println("Your hand is: ")
  println(human.handPrint)

  /** we create the board, empty */
  private var tablero: Board = new Board()
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
  println()
  println("Humans go first against robots")
  while (human.gemCounter > 0 && robot.gemCounter > 0) {
    println("Here is your hand again, you can play a card by choosing a number.")
    println("Any other input will pass your turn.")
    println(human.handPrint)
    pasado = false
    var playMade: String = scala.io.StdIn.readLine()
    playMade match {
      case "0" => if human.getHand.nonEmpty then human.playCard(human.getHand.head, partida) else pasado = true
      case "1" => if human.getHand.length >= 2 then human.playCard(human.getHand(1), partida) else pasado = true
      case "2" => if human.getHand.length >= 3 then human.playCard(human.getHand(2), partida) else pasado = true
      case "3" => if human.getHand.length >= 4 then human.playCard(human.getHand(3), partida) else pasado = true
      case "4" => if human.getHand.length >= 5 then human.playCard(human.getHand(4), partida) else pasado = true
      case "5" => if human.getHand.length >= 6 then human.playCard(human.getHand(5), partida) else pasado = true
      case "6" => if human.getHand.length >= 7 then human.playCard(human.getHand(6), partida) else pasado = true
      case "7" => if human.getHand.length >= 8 then human.playCard(human.getHand(7), partida) else pasado = true
      case "8" => if human.getHand.length >= 9 then human.playCard(human.getHand(8), partida) else pasado = true
      case "9" => if human.getHand.length >= 10 then human.playCard(human.getHand(9), partida) else pasado = true
      case _ => pasado = true
    }
    if pasado then println("You passed your turn\n")

    println()
    println("Computers turn")


    /** we make the robot play a card at random in case it has more potential points
     * than the human's visible points
     *
     * in this case the robot will play a card at random
     */
    if (partida.potentialPoints(robot) > partida.boardPoints(human)) {
      if (robot.getHand.length > 0){
        val manorobot: Int = robot.getHand.length
        val randindex: Int = rand.nextInt(manorobot)
        val cartarobot: Card = robot.getHand(randindex)
        robot.playCard(cartarobot, partida)
        println("Computer played a card: ")
        println(cartarobot)
      }
    } else if (robot.hasClimate)
    /** in case the robot has less power accordind to the previous comparison
     * the robot will play a random weather card if it has one
     */
    {
      var listaClima: List[Int] = List()
      for (i <- robot.getHand.indices) {
        if (robot.getHand(i).isInstanceOf[WeatherCard]) {
          listaClima = listaClima :+ i
        }
      }
      val indice: Int = rand.nextInt(listaClima.length)
      val cartarobot: Card = robot.getHand(listaClima(indice))
      robot.playCard(cartarobot, partida)
      println("Computer played a card: ")
      println(cartarobot)
    } else if (pasado) {
      /**
       * if the robot has no weather cards and the human passed its turn
       * the round is done, counting points procedes
       */
      println("the computer passed its turn")
      println()
      println("Round finished")
      println()
      val ganador: Int = partida.nextRound()
      if (ganador == 1) {
        println("You won the round")
      }
      else if (ganador == 2) {
        println("Computer won the round")
      }
      else {
        println("Round was a draw")
      }
      println("Score is: ")
      println("You: " + human.gemCounter)
      println("Computer: " + robot.gemCounter)
    } else {
    /** otherwise the robot will pass, but the round is not done yet */
      println("the computer passed its turn")
    }



    println("Here is the board:")
    println(tablero)
    println()
    println()
    println("your turn")


  }
  println()
  println("Game finished")
  if (human.gemCounter == 0 && robot.gemCounter == 0) then println("Game was a draw")
  else if (human.gemCounter == 0) then println("You lost")
  else if (robot.gemCounter == 0) then println("You won")
  else throw new Exception("Game ended with invalid state")
//  }
}