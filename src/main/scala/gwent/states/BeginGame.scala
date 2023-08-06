/** in this state we override the method BeginGame, 
 *   so that it advances to either:
 *      the state RobotVSRobot
 *      the state CDHAM
 */

class BeginGame extends States {
    override def BeginGame(stateofgame: StateOfGame): Unit = {
        println("Do you want to play? (y/n)")
        val answer = scala.io.StdIn.readLine()
        if (answer == "y") {
            changeState(stateofgame, new CDHAM())
        } else if (answer == "n") {
            changeState(stateofgame, new RobotVSRobot())
        } else {
            println("Please answer with y or n")
            BeginGame(stateofgame)
        }
    }

    override def isBeginGame(): Boolean = true
}