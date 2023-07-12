package cl.uchile.dcc
package gwent.board

import gwent.cards.*
import gwent.Player
import gwent.board.*

import munit.*

class BoardTest extends munit.FunSuite {
  /** tablero vacio */
  var tablero1: Board = new Board()
  var tablero2: Board = new Board()

  var troop1: CloseCombatCard = _
  var troop2: CloseCombatCard = _
  var troop3: CloseCombatCard = _

  var ranged1: RangedCombatCard = _
  var ranged2: RangedCombatCard = _
  var ranged3: RangedCombatCard = _

  var catapult1: SiegeCombatCard = _
  var catapult2: SiegeCombatCard = _
  var catapult3: SiegeCombatCard = _

  var jugador: Player = _

  override def beforeEach(context: BeforeEach): Unit = {
    tablero1 = Board(List(), List(), List(), List(), List(), List(), List())
    tablero2 = Board(List(catapult1, catapult2, catapult3),  List(ranged1, ranged2, ranged3),  List(troop1, troop2, troop3),  List(climate1), List(troop1, troop2, troop3), List(ranged1, ranged2, ranged3), List(catapult1, catapult2, catapult3))

    climate1 = new ClimateCard("climate1", "lluvia", 1)

    troop1 = new CloseCombatCard("troop1", "pedro", 1)
    troop2 = new CloseCombatCard("troop2", "pablo", 2)
    troop3 = new CloseCombatCard("troop3", "jose", 3)

    ranged1 = new RangedCombatCard("ranged1", "eliana", 1)
    ranged2 = new RangedCombatCard("ranged2", "maria", 2)
    ranged3 = new RangedCombatCard("ranged3", "alia", 3)

    catapult1 = new SiegeCombatCard("catapult1", "isis", 1)
    catapult2 = new SiegeCombatCard("catapult2", "dracula", 2)
    catapult3 = new SiegeCombatCard("catapult3", "atenea", 3)

    jugador = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
  }

  test("tablero vacio") {
    assert(tablero.isEmpty)
  }

  test("test for equals"){
    val tablerodos = new Board(List(troop1, troop2, troop3), List(ranged1, ranged2, ranged3), List(catapult1, catapult2, catapult3))
    assert(tablero == tablero2)
  }
}
