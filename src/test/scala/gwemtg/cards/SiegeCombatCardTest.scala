package hugodiazroa
package gwemtg.cards


import gwemtg.cards.*
import gwemtg.Game
import gwemtg.Player
import gwemtg.board.*
import munit.*

class SiegeCombatCardTest extends munit.FunSuite {
  var troop1: CloseCombatCard = _
  var troop2: CloseCombatCard = _
  var troop3: CloseCombatCard = _

  var ranged1: RangedCombatCard = _
  var ranged2: RangedCombatCard = _
  var ranged3: RangedCombatCard = _

  var catapult1: SiegeCombatCard = _
  var catapult2: SiegeCombatCard = _
  var catapult3: SiegeCombatCard = _

  var climate1: WeatherCard = _
  var climate2: WeatherCard = _

  var jugador: Player = _
  var jugador2: Player = _

  var partida: Game = _

  var tablero1: Board = new Board()


  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CloseCombatCard("troop1", "pedro", 1, 1)
    troop2 = new CloseCombatCard("troop2", "pablo", 2, 2)
    troop3 = new CloseCombatCard("troop3", "jose", 3, 3)

    ranged1 = new RangedCombatCard("ranged1", "eliana", 1, 1)
    ranged2 = new RangedCombatCard("ranged2", "maria", 2, 2)
    ranged3 = new RangedCombatCard("ranged3", "alia", 3, 3)

    catapult1 = new SiegeCombatCard("catapult1", "isis", 1, 1)
    catapult2 = new SiegeCombatCard("catapult2", "dracula", 2, 2)
    catapult3 = new SiegeCombatCard("catapult3", "atenea", 3, 3)

    climate1 = new WeatherCard("climate1", "lluvia")
    climate2 = new WeatherCard("climate2", "nieve")

    jugador = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2, climate2))
    jugador2 = new Player("Lain", 2, List(), List())

    partida = new Game(tablero1, jugador, jugador)

    tablero1 = new Board()

  }

  
  test("test for equals") {
    val catapultauno: SiegeCombatCard = new SiegeCombatCard("catapult1", "isis", 1, 1)
    assertEquals(catapult1, catapultauno, "two cards with the same name, description and power should be equal")
    assertNotEquals(catapult1, catapult2, "two cards with different name, description or power should not be equal")
    assertEquals(catapult1, catapult1, "a card should be equal to itself")
  }

  test("test for hashcode") {
    val catapultauno: SiegeCombatCard = new SiegeCombatCard("catapult1", "isis", 1, 1)
    assertEquals(catapult1.hashCode(), catapultauno.hashCode(), "two cards with the same name, description and power should have the same hashcode")
    assertNotEquals(catapult1.hashCode(), catapult2.hashCode(), "two cards with different name, description or power should not have the same hashcode")
    assertEquals(catapult1.hashCode(), catapult1.hashCode(), "a card should have the same hashcode as itself")
    assert(catapultauno.canEqual(catapult1), "two cards with the same name, description and power should be able to be compared")
    assert(catapult1.canEqual(catapultauno), "two cards with the same name, description and power should be able to be compared")
  }
  test("test for getters") {
    assertEquals(catapult1.getName, "catapult1")
    assertEquals(catapult1.getDescription, "isis")
    assertEquals(catapult1.getPower, 1)
    assertEquals(catapult1.getOGPower, 1)
  }

  test("test for setPower"){
    assertEquals(catapult1.getPower, 1)
    catapult1.setPower(2)
    assertEquals(catapult1.getPower, 2)
    assertEquals(catapult1.getOGPower, 1)
  }

}