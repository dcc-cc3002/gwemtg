package cl.uchile.dcc
package gwent

import gwent.cards.*

/** Clase representando un tablero (Board) en el juego Gwen't.
 *
 * Cada tablero tiene seis zonas
 *
 * @constructor Crea un nuevi Board.
 *              Board tiene las siguientes variables
 * @var siegeP1
 * @var rengeP1
 * @var closeP1
 * @var world
 * @var closeP2
 * @var rengeP2
 * @var siegeP2

 * @author hugodiazroa
 *         (comenta en espanxol)
 *
 */

class Board(){
  private var siegeP1: List[SiegeCombatCard] = List()
  private var rangeP1: List[RangedCombatCard] = List()
  private var closeP1: List[CloseCombatCard] = List()
  private var world: WeatherCard = null
  private var closeP2: List[CloseCombatCard] = List()
  private var rangeP2: List[RangedCombatCard] = List()
  private var siegeP2: List[SiegeCombatCard] = List()

  /** getters */
  def getSP1: List[SiegeCombatCard] = this.siegeP1
  def getRP1: List[RangedCombatCard] = this.rangeP1
  def getCP1: List[CloseCombatCard] = this.closeP1
  def getWorld: WeatherCard = this.world
  def getCP2: List[CloseCombatCard] = this.closeP2
  def getRP2: List[RangedCombatCard] = this.rangeP2
  def getSP2: List[SiegeCombatCard] = this.siegeP2

  /** setters */
  def setSP1(cards: List[SiegeCombatCard]): Unit = this.siegeP1 = cards
  def setRP1(cards: List[RangedCombatCard]): Unit = this.rangeP1 = cards
  def setCP1(cards: List[CloseCombatCard]): Unit = this.closeP1 = cards
  def setWorld(card: WeatherCard): Unit = this.world = card
  def setCP2(cards: List[CloseCombatCard]): Unit = this.closeP2 = cards
  def setRP2(cards: List[RangedCombatCard]): Unit = this.rangeP2 = cards
  def setSP2(cards: List[SiegeCombatCard]): Unit = this.siegeP2 = cards

  /** metodos para adjuntar cartas a las listas */
  def appendSP1(card: SiegeCombatCard): Unit = this.siegeP1 = card :: this.siegeP1
  def appendRP1(card: RangedCombatCard): Unit = this.rangeP1 = card :: this.rangeP1
  def appendCP1(card: CloseCombatCard): Unit = this.closeP1 = card :: this.closeP1
  def appendSP2(card: SiegeCombatCard): Unit = this.siegeP2 = card :: this.siegeP2
  def appendRP2(card: RangedCombatCard): Unit = this.rangeP2 = card :: this.rangeP2
  def appendCP2(card: CloseCombatCard): Unit = this.closeP2 = card :: this.closeP2
}
