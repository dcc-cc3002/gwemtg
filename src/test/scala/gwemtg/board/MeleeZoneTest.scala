package hugodiazroa
package gwemtg.board

import gwemtg.cards.*
import gwemtg.Player
import gwemtg.Game
import munit.*

class MeleeZoneTest extends munit.FunSuite{
  var tablero1: Board = _
  var tablero2: Board = _
  var tablero3: Board = _

  var zona1siege: MarginalZone = _
  var zona1range: RangeZone = _
  var zona1melee: MeleeZone = _
  var zonaclimate: ClimateZone = _
  var zona2melee: MeleeZone = _
  var zona2range: RangeZone = _
  var zona2siege: MarginalZone = _

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
    tablero2 = new Board(new MarginalZone(List(catapult1, catapult2, catapult3)), new RangeZone(List(ranged1, ranged2, ranged3)), new MeleeZone(List(troop1, troop2, troop3)), new ClimateZone(List(climate1)), new MeleeZone(List(troop1, troop2, troop3)), new RangeZone(List(ranged1, ranged2, ranged3)), new MarginalZone(List(catapult1, catapult2, catapult3)))

    zona1siege = new MarginalZone(List(catapult1, catapult2, catapult3))
    zona1range = new RangeZone(List(ranged1, ranged2, ranged3))
    zona1melee = new MeleeZone(List(troop1, troop2, troop3))
    zonaclimate = new ClimateZone(List(climate1))
    zona2melee = new MeleeZone(List(troop1, troop2, troop3))
    zona2range = new RangeZone(List(ranged1, ranged2, ranged3))
    zona2siege = new MarginalZone(List(catapult1, catapult2, catapult3))

    tablero3 = new Board(zona1siege, zona1range, zona1melee, zonaclimate, zona2melee, zona2range, zona2siege)
  }

  test("test for equals") {
    val testzona1melee = new MeleeZone(List(troop1, troop2, troop3))
    assertEquals(zona1melee, zona1melee, "zona1siege should be equal to itself")
    assertEquals(zona1melee, testzona1melee)
    assertNotEquals(zona1melee, new MeleeZone(List(troop1, troop2)))
    assertEquals(zona1melee, zona2melee)
    assertNotEquals( new MeleeZone(List(troop1, troop2)), zona1melee)
  }

  test("test for hashCode") {
    assertEquals(zona1melee.hashCode(), new MeleeZone(List(troop1, troop2, troop3)).hashCode())
    assertNotEquals(zona1melee.hashCode(), new MeleeZone(List()).hashCode())
  }
}

