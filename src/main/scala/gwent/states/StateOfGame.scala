package cl.uchile.dcc
package gwent

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



class StateOfGame {
    private var state: State = new BeginGame
    private var log: List[State] = List()

    def getState(): State = state
    def setState(newState: State): Unit = {
        state = newState
        log = log :+ state
    }


    def BeginGame(): Unit = State.BeginGame(this)
    def RobotVSRobot(): Unit = State.RobotVSRobot(this)
    def CDHAM(): Unit = State.CDHAM(this)
    def PlayRound(): Unit = State.PlayRound(this)
    def SubstractGems(): Unit = State.SubstractGems(this)
    def ChangeBoard(): Unit = State.ChangeBoard(this)
    def ShowResult(): Unit = State.ShowResult(this)

    def isBeginGame(): Boolean = State.isBeginGame(this)
    def isRobotVSRobot(): Boolean = State.isRobotVSRobot(this)
    def isPlayRound(): Boolean = State.isPlayRound(this)
    def isGameFinished(): Boolean = State.isGameFinished(this)

}