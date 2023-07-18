package cl.uchile.dcc
package gwent

import gwent.cards.*
import gwent.board.*
import gwent.Player
import munit.*

class GameTest extends munit.FunSuite{

  var tablero1: Board = new Board()
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
  var climate3: WeatherCard = _
  var climate4: WeatherCard = _

  var jugador1: Player = _
  var jugador2: Player = _

  var partida: Game = _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CloseCombatCard("troop1", "pedro", 1)
    troop2 = new CloseCombatCard("troop2", "pablo", 2)
    troop3 = new CloseCombatCard("troop3", "jose", 3)

    ranged1 = new RangedCombatCard("ranged1", "eliana", 1)
    ranged2 = new RangedCombatCard("ranged2", "maria", 2)
    ranged3 = new RangedCombatCard("ranged3", "alia", 3)

    catapult1 = new SiegeCombatCard("catapult1", "isis", 1)
    catapult2 = new SiegeCombatCard("catapult2", "dracula", 2)
    catapult3 = new SiegeCombatCard("catapult3", "atenea", 3)

    jugador1 = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    jugador2 = new Player("Lya", 2, List(), List())

    climate1 = new WeatherCard("climate1", "lluvia")
    climate2 = new WeatherCard("climate2", "nieve")
    climate3 = new WeatherCard("climate3", "sol")
    climate4 = new WeatherCard("climate4", "niebla")

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

    partida = new Game(tablero1, jugador1, jugador2)
  }

  test("Game constructor for beforeEach"){
    assertEquals(partida.board, tablero1)
    assertEquals(partida.getP1, jugador1)
    assertEquals(partida.getP2, jugador2)
  }

  test("Game constructor for a particular test") {
    val partida2 = new Game(tablero2, jugador1, jugador2)
    assertEquals(partida2.board, tablero2)
    assertEquals(partida2.getP1, jugador1)
    assertEquals(partida2.getP2, jugador2)
  }

  /**
   * exception to the rule, two identical games should be different even if everything is equal
   * ie. partida and partida3 are different even if they have the same board, players and cards
   * this is good, we don't override hashcode because two games are different even in the same conditions
   */
  test("test for hashcode"){
    val partida2 = new Game(tablero2, jugador1, jugador2)
    val partida3 = new Game(tablero1, jugador1, jugador2)
    assertNotEquals(partida.hashCode(), partida2.hashCode())
    assertNotEquals(partida.hashCode(), partida3.hashCode())
    assertNotEquals(partida2.hashCode(), partida3.hashCode())
  }

  test("tests for playing cards"){
    assertEquals(partida.getP1.getHand, List(troop2, ranged2, catapult2))
    assertEquals(partida.board.p1m.hashCode(), new MeleeZone(List()).hashCode())
    partida.getP1.playCard(troop2, partida)
    assertEquals(partida.getP1.getHand, List(ranged2, catapult2))
    assertEquals(partida.board.p1m.hashCode(), new MeleeZone(List(troop2)).hashCode())
  }

  test("tests for playing cards but for player 2: jugador2"){
    assertEquals(partida.getP2.getHand, List())
    assertEquals(partida.board.p2m.hashCode(), new MeleeZone(List()).hashCode())
    partida.getP2.playCard(troop2, partida)
    assertEquals(partida.getP2.getHand, List())
    assertEquals(partida.board.p2m.hashCode(), new MeleeZone(List(troop2)).hashCode())
  }

    test("tests for getters"){
    assertEquals(partida.getP1, jugador1)
    assertEquals(partida.getP2, jugador2)
  }

  test("tests for calculating potential, board and hand points"){
    assertEquals(partida.handPoints(partida.getP1), 6)
    assertEquals(partida.boardPoints(partida.getP1), 0)
    assertEquals(partida.potentialPoints(partida.getP1), 6)
    partida.getP1.playCard(troop2, partida)
    assertEquals(partida.handPoints(partida.getP1), 4)
    assertEquals(partida.boardPoints(partida.getP1), 2)
    assertEquals(partida.potentialPoints(partida.getP1), 6)
    partida.getP1.playCard(ranged2, partida)
    assertEquals(partida.handPoints(partida.getP1), 2)
    assertEquals(partida.boardPoints(partida.getP1), 4)
    assertEquals(partida.potentialPoints(partida.getP1), 6)
    partida.getP1.playCard(catapult2, partida)
    assertEquals(partida.handPoints(partida.getP1), 0)
    assertEquals(partida.boardPoints(partida.getP1), 6)
    assertEquals(partida.potentialPoints(partida.getP1), 6)
  }

  test("P2: tests for calculating potential, board and hand points") {
    val partida2: Game = new Game(tablero1, jugador2, jugador1)
    assertEquals(partida2.handPoints(partida2.getP2), 6)
    assertEquals(partida2.boardPoints(partida2.getP2), 0)
    assertEquals(partida2.potentialPoints(partida2.getP2), 6)
    partida2.getP2.playCard(troop2, partida2)
    assertEquals(partida2.handPoints(partida2.getP2), 4)
    assertEquals(partida2.boardPoints(partida2.getP2), 2)
    assertEquals(partida2.potentialPoints(partida2.getP2), 6)
    partida2.getP2.playCard(ranged2, partida2)
    assertEquals(partida2.handPoints(partida2.getP2), 2)
    assertEquals(partida2.boardPoints(partida2.getP2), 4)
    assertEquals(partida2.potentialPoints(partida2.getP2), 6)
    partida2.getP2.playCard(catapult2, partida2)
    assertEquals(partida2.handPoints(partida2.getP2), 0)
    assertEquals(partida2.boardPoints(partida2.getP2), 6)
    assertEquals(partida2.potentialPoints(partida2.getP2), 6)
  }

  test("test for nextRound"){
    assertEquals(partida.nextRound(),0)
    val partida3 = new Game(tablero2, jugador1, jugador2)
    assertEquals(partida3.nextRound(),0)
    val tablero4 = new Board(zona1siege, zona1range, new MeleeZone(), zonaclimate, zona2melee, zona2range, zona2siege)
    val tablero5 = new Board(zona1siege, zona1range, zona2melee, zonaclimate, new MeleeZone(), zona2range, zona2siege)
    val partida4 = new Game(tablero4, jugador1, jugador2)
    val partida5 = new Game(tablero5, jugador1, jugador2)
    assertEquals(partida4.nextRound(),2)
    assertEquals(partida5.nextRound(),1)
  }
}
