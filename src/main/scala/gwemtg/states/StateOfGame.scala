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
import gwemtg.cards.{Card, *}

class StateOfGame() {
    private var state: Estado = new BeginGame()
    private var log: List[Estado] = List()

    var player1: Player = _
    var player2: Player = _
    var board: Board = _
    var game: Game = _

    def getState: Estado = state
    def setState(newState: Estado): Unit = {
        state = newState
        log = log :+ state
    }

    def BeginGame(): Unit = state BeginGame this
    def RobotVSRobot(): Unit = state RobotVSRobot this
    def CDHAM(): Unit = state CDHAM this
    def PlayRound(): Unit = state PlayRound this
    def SubstractGems(): Unit = state SubstractGems this
    def ChangeBoard(): Unit = state ChangeBoard this
    def Draw(): Unit = state Draw this
    def P1Win(): Unit = state P1Win this
    def P2Win(): Unit = state P2Win this
    def ShowResult(): Unit = state ShowResult this

    def isBeginGame(): Boolean = state.isBeginGame()
    def isRobotVSRobot(): Boolean = state.isRobotVSRobot()
    def isPlayRound(): Boolean = state.isPlayRound()
    def isGameFinished(): Boolean = state.isGameFinished()
    
}