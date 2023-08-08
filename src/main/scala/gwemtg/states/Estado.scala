package hugodiazroa
package gwemtg
package states

import gwemtg.states.StateOfGame
import gwemtg.cards._

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

class Estado() {
    /**
     * changeState:
     * following the state pattern, we define the way to change the state of the game
     * this is done by changing the state of the stateofgame object
     */
    protected def changeState(stateofgame: StateOfGame, newState: Estado): Unit = {
        stateofgame.setState(newState)
    }

    private def error() = throw new Exception("Error: wrong state")

    def BeginGame(stateofgame: StateOfGame): Unit = error()
    //def RobotVSRobot(stateofgame: StateOfGame): Unit = error()
    def CDHAM(stateofgame: StateOfGame): Unit = error()
    def PlayRound(stateofgame: StateOfGame): Unit = error()
    def SubstractGems(stateofgame: StateOfGame): Unit = error()
    //def ChangeBoard(stateofgame: StateOfGame): Unit = error()
    def ShowResult(stateofgame: StateOfGame): Unit = error()
    def Draw(stateofgame: StateOfGame): Unit = error()
    def P1Win(stateofgame: StateOfGame): Unit = error()
    def P2Win(stateofgame: StateOfGame): Unit = error()

    def isBeginGame(): Boolean = false

    //def isRobotVSRobot(): Boolean = false

    def isPlayRound(): Boolean = false

    def isDraw(): Boolean = false
    def isP1Victory(): Boolean = false
    def isP2Victory(): Boolean = false
}