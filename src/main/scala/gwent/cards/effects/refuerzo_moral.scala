package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.{AbstractUnitCard, CloseCombatCard, RangedCombatCard, SiegeCombatCard}

/** Trait representing a refuerzo_moral effect
  *
  * It has a override metho for getPlayed
  * the method is used to excecute effect [nameofclass] in the game
  * the excecution does [[effect nameofclass]]
  */

trait refuerzo_moral extends AbstractUnitCard
{
  /** do nothing */
  override def getPlayed(): Unit = {
    super.refuerzo_moral()
    getPlayed()
  }
}
