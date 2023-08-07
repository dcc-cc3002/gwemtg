package cl.uchile.dcc
package gwent

/** in this state we override the method BeginGame, 
 *   so that it advances to either:
 *      the state RobotVSRobot
 *      the state CDHAM
 */

class BeginGame extends Estado {
    override def BeginGame(stateofgame: StateOfGame): Unit = {
        println("Do you want to play? (y/n)")
        val answer = scala.io.StdIn.readLine()
        if (answer == "y") {
            this.changeState(stateofgame, new CDHAM())
        } else if (answer == "n") {
            this.changeState(stateofgame, new RobotVSRobot())
        } else {
            println("Please answer with y or n")
            this.changeState(stateofgame, new BeginGame())
        }
    }

    override def isBeginGame: Boolean = true
}