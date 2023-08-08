package hugodiazroa
package gwemtg.states

class P2Win extends Estado {
  override def P2Win(stateofgame: StateOfGame): Unit = {
    println("Player 2 won the game")
  }

  override def isP2Victory(): Boolean = true
}
