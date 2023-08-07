/**
  * PlayRound is a state that represents the state of playing a round in the game.
  * In this state we override the method PlayRound, so that it advances to either: 
  * if both players pass, the game advances to the state << subtract gems >>
  * if there is a player that does not pass, the game advances to the state << change board >>  
  */

class PlayRound extends States {
    override def PlayRound(stateofgame: StateOfGame): Unit = {
        println("Do you want to play a card? select the index of the card you want to play, or to pass press enter")
        val answer = scala.io.StdIn.readLine()
        if (answer in x ) {
            changeState(stateofgame, new SubstractGems())
        } else {
            /** let's see what the robot does */
            
            /** we make the robot play a card at random in case it has more potential points
             * than the human's visible points
             *
             * in this case the robot will play a card at random
             * and we will advance to the state << change board >>
             */
            if (stateofgame.getMatch().boardPoints(stateofgame.getMatch.getPlayer1) > stateofgame.getMatch().boardPoints(stateofgame.getMatch.getPlayer2))
            {
                stateofgame.getMatch.getP2
                changeState(stateofgame, new ChangeBoard())
            } else {
                /** if the robot has less potential points than the human's visible points
                 * we will make the robot pass
                 * and we will advance to the state << subtract gems >>
                 */
                stateofgame.getMatch.nextRound()
                changeState(stateofgame, new SubstractGems())
            }

            /** if the robot passes, we advance to the state << subtract gems >> */
            /** if the robot plays a card, we advance to the state << change board >> */
        } 
    }

    override def isPlayRound(): Boolean = true
}