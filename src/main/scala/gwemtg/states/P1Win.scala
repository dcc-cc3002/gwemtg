package hugodiazroa
package gwemtg.states

class P1Win extends Estado {
  override def P1Win(stateofgame: StateOfGame): Unit = {
    println("Player 1 won the game")
  }

  override def isP1Victory(): Boolean = true
}
