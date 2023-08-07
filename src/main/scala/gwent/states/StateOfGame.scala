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
    private var state: Estado = new BeginGame
    private var log: List[Estado] = List()

    def getState: Estado = state
    def setState(newState: Estado): Unit = {
        state = newState
        log = log :+ state
    }


    def BeginGame(): Unit = Estado.BeginGame(this)
    def RobotVSRobot(): Unit = Estado.RobotVSRobot(this)
    def CDHAM(): Unit = Estado.CDHAM(this)
    def PlayRound(): Unit = Estado.PlayRound(this)
    def SubstractGems(): Unit = Estado.SubstractGems(this)
    def ChangeBoard(): Unit = Estado.ChangeBoard(this)
    def Draw(): Unit = Estado.Draw(this)
    def P1Win(): Unit = Estado.ShowResult(this)
    def P2Win(): Unit = Estado.ShowResult(this)

    def isBeginGame: Boolean = Estado.isBeginGame(this)
    def isRobotVSRobot: Boolean = Estado.isRobotVSRobot(this)
    def isPlayRound: Boolean = Estado.isPlayRound(this)
    def isGameFinished: Boolean = Estado.isGameFinished(this)

}