package hugodiazroa
package gwemtg.states
/**
  * PlayRound is a state that represents the state of playing a round in the game.
  * In this state we override the method PlayRound, so that it advances to either: 
  * if both players pass, the game advances to the state << subtract gems >>
  * if there is a player that does not pass, the game advances to the state << change board >>  
  */

import gwemtg.states.*

class PlayRound extends Estado {
    override def PlayRound(stateofgame: StateOfGame): Unit = {
        println("Do you want to play a card? select the index of the card you want to play, or to pass press enter")
        val answer = scala.io.StdIn.readLine()
        if 0 to 16 contains answer.toInt then this.changeState(stateofgame, new SubstractGems())
            /** let's see what the robot does */
            
            /** we make the robot play a card at random in case it has more potential points
             * than the human's visible points
             *
             * in this case the robot will play a card at random
             * and we will advance to the state << change board >>
             */
        else if (stateofgame.game.boardPoints(stateofgame.player1) > stateofgame.game.boardPoints(stateofgame.player2))
            {
                this.changeState(stateofgame, new ChangeBoard())
            } else {
                /** if the robot has less potential points than the human's visible points
                 * we will make the robot pass
                 * and we will advance to the state << subtract gems >>
                 */
                stateofgame.game.nextRound()
                this.changeState(stateofgame, new SubstractGems())
            }

            /** if the robot passes, we advance to the state << subtract gems >> */
            /** if the robot plays a card, we advance to the state << change board >> */
        
    }

    override def isPlayRound() = true
}