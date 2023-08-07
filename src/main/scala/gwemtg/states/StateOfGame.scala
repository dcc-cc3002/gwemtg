package hugodiazroa
package gwemtg.states

/**
 * in this file we define the state of the game
 * the state of the game is defined by the following:
 * at the beginning of the game, the state is << begin game >>
 * in the state << begin game >> the state advances to an if statement
 * here the user is asked if he wants to play or not,
 *  if he does not the game, play a match between two robots
 *  if he does, the game advances to the state << create decks, hands, and match>>
 *    then the game advances to the state << play match >>
 *    in the state: << two players alive? >> the game loops while yes, advancing to << play round >>
 *
 *      each instance of the state << play round >> advances to the state << both players pass? >>
 *        if both players pass, the game advances to the state << subtract gems >>
 *          then the game returns to the state << two players alive? >>
 *        if there is a player that does not pass, the game advances to the state << change board >>
 *          then the game returns to the state << play round >>
 *
 *    if there are not two players alive, the program ends in the state << show winner (or draw) >>
 */

import gwemtg.states.*
import gwemtg.Game
import gwemtg.Player
import gwemtg.board.Board
import gwemtg.DeckBuilder
import gwemtg.cards.*

class StateOfGame() {
    private var state: Estado = new BeginGame()
    private var log: List[Estado] = List()

    private var player1: Player = _
    private var player2: Player = _
    private var board: Board = _
    private var game: Game = _

    def getState: Estado = state
    def setState(newState: Estado): Unit = {
        state = newState
        log = log :+ state
    }

    def BeginGame(): Unit = Estado BeginGame this
    def RobotVSRobot(): Unit = Estado RobotVSRobot this
    def CDHAM(): Unit = Estado CDHAM this
    def PlayRound(): Unit = Estado PlayRound this
    def SubstractGems(): Unit = Estado SubstractGems this
    def ChangeBoard(): Unit = Estado ChangeBoard this
    def Draw(): Unit = Estado Draw this
    def P1Win(): Unit = Estado P1Win this
    def P2Win(): Unit = Estado P2Win this
    def ShowResult(): Unit = Estado ShowResult this

    def isBeginGame(): Boolean = Estado.isBeginGame()
    def isRobotVSRobot(): Boolean = Estado.isRobotVSRobot()
    def isPlayRound(): Boolean = Estado.isPlayRound()
    def isGameFinished(): Boolean = Estado.isGameFinished()



    /**
     * createDecks
     * this method is in charge of creating the decks
     * it is accomplished by calling the class DeckBuilder
     */
    def createDecks: (List[Card], List[Card]) = {
        val deck_builder = new DeckBuilder()
        val deck1 = deck_builder.buildDeck()
        val deck2 = deck_builder.buildDeck()
        (deck1, deck2)
    }

    /**
     * createHands
     * this method is in charge of creating the hands
     */
    def createHands: (List[Card], List[Card]) = {
        val hand1 = List()
        val hand2 = List()
        (hand1, hand2)
    }

    /**
     * this method is used to initialize the game
     * player1: the first player
     * player2: the second player
     * @param deck1 the deck of the first player
     * @param deck2 the deck of the second player
     * @param hand1 the hand of the first player
     * @param hand2 the hand of the second player
     * @param board the board of the game
     * game: the game
     *
     * @return the game
     */
    def createMatch(deck1: List[Card], deck2: List[Card], hand1: List[Card], hand2: List[Card], board: Board): Game = {
        this.player1 = new Player("human", 2, deck1, hand1)
        this.player2 = new Player("robot", 2, deck2, hand2)
        this.board = new Board()
        val game: Game = new Game(this.board, player1, player2)
        game
    }


    /**
     * getMatch
     * this method is in charge of retrieving the match from the StateOfGame class that is in charge of the game
     */
    def getMatch: Game = this.game

}