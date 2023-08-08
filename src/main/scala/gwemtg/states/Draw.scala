package hugodiazroa
package gwemtg.states

import gwemtg.states.*

class Draw extends Estado {
  override def Draw(stateofgame: StateOfGame): Unit = {
    println("Game ended in a draw")
  }

  override def isDraw(): Boolean = true
}
