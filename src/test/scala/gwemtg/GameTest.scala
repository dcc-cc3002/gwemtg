package cl.uchile.dcc
package gwemtg

import gwemtg.cards.*
import gwemtg.board.*
import gwemtg.Player

import munit.*

class GameTest extends munit.FunSuite {

  var tablero1: Board = new Board()
  var tablero2: Board = _
  var tablero3: Board = _
  var bitingFrost: WeatherCard = _
  var impenetrableFog: WeatherCard = _
  var torrentialRain: WeatherCard = _
  var clearWeather: WeatherCard = _
  var commanderHorn: WeatherCard = _
  var geraltOfRivia: CloseCombatCard = _
  var yenneferOfVengerberg: RangedCombatCard = _
  var ciri: RangedCombatCard = _
  var vesemir: SiegeCombatCard = _
  var dandelion: SiegeCombatCard = _
  var trissMerigold: CloseCombatCard = _
  var yen: RangedCombatCard = _
  var eskel: CloseCombatCard = _
  var lambert: SiegeCombatCard = _
  var zoltanChivay: CloseCombatCard = _

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

    bitingFrost = new WeatherCard("Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de melee a 1")
    impenetrableFog = new WeatherCard("Niebla Impenetrable", "Convierte el valor de fuerza de todas las cartas de rango a 1.")
    torrentialRain = new WeatherCard("LLuvia Torrencial", "Convierte el valor de fuerza de todas las cartas de asedio a 1.")
    clearWeather = new WeatherCard("Despejar", "Limpia todos los efectos de clima del campo de batalla.")
    commanderHorn = new WeatherCard("Cuerno del Comandante", "Dobla la fuerza de todas las unidades de una fila propia al azar.")

    geraltOfRivia = new CloseCombatCard("Geralt of Rivia", "vainilla", 5)
    yenneferOfVengerberg = new RangedCombatCard("Yennefer of Vengerberg", "vinculo_estrecho", 3)
    ciri = new RangedCombatCard("Ciri", "vainilla", 4)
    vesemir = new SiegeCombatCard("Vesemir", "refuerzo_moral", 5)
    dandelion = new SiegeCombatCard("Dandelion", "vinculo_estrecho", 3)
    trissMerigold = new CloseCombatCard("Triss Merigold", "vainilla", 5)
    yen = new RangedCombatCard("Yen", "refuerzo_moral", 6)
    eskel = new CloseCombatCard("Eskel", "refuerzo_moral", 3)
    lambert = new SiegeCombatCard("Lambert", "vainilla", 6)
    zoltanChivay = new CloseCombatCard("Zoltan Chivay", "vinculo_estrecho", 4)

  }

  test("Game constructor for beforeEach") {
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
  test("test for hashcode") {
    val partida2 = new Game(tablero2, jugador1, jugador2)
    val partida3 = new Game(tablero1, jugador1, jugador2)
    assertNotEquals(partida.hashCode(), partida2.hashCode())
    assertNotEquals(partida.hashCode(), partida3.hashCode())
    assertNotEquals(partida2.hashCode(), partida3.hashCode())
  }

  test("tests for playing cards") {
    assertEquals(partida.getP1.getHand, List(troop2, ranged2, catapult2))
    assertEquals(partida.board.p1m.hashCode(), new MeleeZone(List()).hashCode())
    partida.getP1.playCard(troop2, partida)
    assertEquals(partida.getP1.getHand, List(ranged2, catapult2))
    assertEquals(partida.board.p1m.hashCode(), new MeleeZone(List(troop2)).hashCode())
  }

  test("tests for playing cards but for player 2: jugador2") {
    assertEquals(partida.getP2.getHand, List())
    assertEquals(partida.board.p2m.hashCode(), new MeleeZone(List()).hashCode())
    partida.getP2.playCard(troop2, partida)
    assertEquals(partida.getP2.getHand, List())
    assertEquals(partida.board.p2m.hashCode(), new MeleeZone(List(troop2)).hashCode())
  }

  test("tests for getters") {
    assertEquals(partida.getP1, jugador1)
    assertEquals(partida.getP2, jugador2)
  }

  test("tests for calculating potential, board and hand points") {
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

  test("test for nextRound") {
    jugador1 = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    jugador2 = new Player("Dios", 2, List(troop3, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    val partida3 = new Game(tablero2, jugador1, jugador2)
    val partida4 = new Game(new Board(zona1siege, new RangeZone(), new MeleeZone(), zonaclimate, zona2melee, zona2range, zona2siege), jugador1, jugador2)
    assertEquals(partida3.nextRound(), 0)
    assertEquals(partida4.nextRound(), 2)
    jugador1 = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    jugador2 = new Player("Dios", 2, List(troop3, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    val partida5 = new Game(new Board(zona1siege, zona1range, zona2melee, zonaclimate, new MeleeZone(), new RangeZone(), new MarginalZone()), jugador1, jugador2)
    assertEquals(partida5.nextRound(), 1)
  }

  test("test for addWC: escarcha mordiente") {
    val p1: Player = new Player("p1", 1, List(), List(bitingFrost))
    val p2: Player = new Player("p2", 2, List(), List())
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(bitingFrost))
    p1.playCard(bitingFrost, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for addWC: niebla impenetrable") {
    val p1: Player = new Player("p1", 1, List(), List(impenetrableFog))
    val p2: Player = new Player("p2", 2, List(), List())
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(impenetrableFog))
    p1.playCard(impenetrableFog, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }


  test("test for addWC: lluvia torrencial") {
    val p1: Player = new Player("p1", 1, List(), List(torrentialRain))
    val p2: Player = new Player("p2", 2, List(), List())
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(torrentialRain))
    p1.playCard(torrentialRain, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for addWC: despejar") {
    val p1: Player = new Player("p1", 1, List(), List(clearWeather))
    val p2: Player = new Player("p2", 2, List(), List())
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(clearWeather))
    p1.playCard(clearWeather, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for addWC: cuerno del comandante") {
    val p1: Player = new Player("p1", 1, List(), List(commanderHorn))
    val p2: Player = new Player("p2", 2, List(), List())
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(commanderHorn))
    p1.playCard(commanderHorn, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for addWC: player 2, cuerno del comandante") {
    val p1: Player = new Player("p1", 1, List(), List())
    val p2: Player = new Player("p2", 2, List(), List(commanderHorn))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP2.getHand, List(commanderHorn))
    p2.playCard(commanderHorn, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for random card") {
    val p1: Player = new Player("p1", 1, List(), List())
    val p2: Player = new Player("p2", 2, List(), List(climate1))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP2.getHand, List(climate1))
    p2.playCard(climate1, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for refuerzo_moral") {
    val p1: Player = new Player("p1", 1, List(), List(eskel, vesemir, yen))
    val p2: Player = new Player("p2", 2, List(), List(eskel, vesemir, yen))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(eskel, vesemir, yen))
    assertEquals(g.getP2.getHand, List(eskel, vesemir, yen))
    p1.playCard(eskel, g)
    p2.playCard(eskel, g)
    assertEquals(g.getP1.getHand, List(vesemir, yen))
    assertEquals(g.getP2.getHand, List(vesemir, yen))
    p1.playCard(vesemir, g)
    p2.playCard(vesemir, g)
    assertEquals(g.getP1.getHand, List(yen))
    assertEquals(g.getP2.getHand, List(yen))
    p1.playCard(yen, g)
    p2.playCard(yen, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for vinculo_estrecho") {
    val p1: Player = new Player("p1", 1, List(), List(zoltanChivay, dandelion, yenneferOfVengerberg))
    val p2: Player = new Player("p2", 2, List(), List(zoltanChivay, dandelion, yenneferOfVengerberg))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(zoltanChivay, dandelion, yenneferOfVengerberg))
    assertEquals(g.getP2.getHand, List(zoltanChivay, dandelion, yenneferOfVengerberg))
    p1.playCard(zoltanChivay, g)
    p2.playCard(zoltanChivay, g)
    assertEquals(g.getP1.getHand, List(dandelion, yenneferOfVengerberg))
    assertEquals(g.getP2.getHand, List(dandelion, yenneferOfVengerberg))
    p1.playCard(dandelion, g)
    p2.playCard(dandelion, g)
    assertEquals(g.getP1.getHand, List(yenneferOfVengerberg))
    assertEquals(g.getP2.getHand, List(yenneferOfVengerberg))
    p1.playCard(yenneferOfVengerberg, g)
    p2.playCard(yenneferOfVengerberg, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for vainilla"){
    val p1: Player = new Player("p1", 1, List(), List(geraltOfRivia, ciri, lambert))
    val p2: Player = new Player("p2", 2, List(), List(geraltOfRivia, ciri, lambert))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)
    assertEquals(g.getP1.getHand, List(geraltOfRivia, ciri, lambert))
    assertEquals(g.getP2.getHand, List(geraltOfRivia, ciri, lambert))
    p1.playCard(geraltOfRivia, g)
    p2.playCard(geraltOfRivia, g)
    assertEquals(g.getP1.getHand, List(ciri, lambert))
    assertEquals(g.getP2.getHand, List(ciri, lambert))
    p1.playCard(ciri, g)
    p2.playCard(ciri, g)
    assertEquals(g.getP1.getHand, List(lambert))
    assertEquals(g.getP2.getHand, List(lambert))
    p1.playCard(lambert, g)
    p2.playCard(lambert, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("test for doble vinculo_estrecho") {
    val p1: Player = new Player("p1", 1, List(), List(zoltanChivay, dandelion, yenneferOfVengerberg,zoltanChivay, dandelion, yenneferOfVengerberg))
    val p2: Player = new Player("p2", 2, List(), List(zoltanChivay, dandelion, yenneferOfVengerberg, zoltanChivay, dandelion, yenneferOfVengerberg))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)

    p1.playCard(zoltanChivay, g)
    p2.playCard(zoltanChivay, g)
    p1.playCard(zoltanChivay, g)
    p2.playCard(zoltanChivay, g)
    p1.playCard(dandelion, g)
    p2.playCard(dandelion, g)
    p1.playCard(dandelion, g)
    p2.playCard(dandelion, g)
    p1.playCard(yenneferOfVengerberg, g)
    p2.playCard(yenneferOfVengerberg, g)
    p1.playCard(yenneferOfVengerberg, g)
    p2.playCard(yenneferOfVengerberg, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }
  test("test for doble refuerzo_moral") {
    val p1: Player = new Player("p1", 1, List(), List(eskel, vesemir, yen, eskel, vesemir, yen))
    val p2: Player = new Player("p2", 2, List(), List(eskel, vesemir, yen, eskel, vesemir, yen))
    val t: Board = new Board()
    val g: Game = new Game(t, p1, p2)

    p1.playCard(eskel, g)
    p2.playCard(eskel, g)
    p1.playCard(eskel, g)
    p2.playCard(eskel, g)
    p1.playCard(vesemir, g)
    p2.playCard(vesemir, g)
    p1.playCard(vesemir, g)
    p2.playCard(vesemir, g)
    p1.playCard(yen, g)
    p2.playCard(yen, g)
    p1.playCard(yen, g)
    p2.playCard(yen, g)
    assertEquals(g.getP1.getHand, List())
    assertEquals(g.getP2.getHand, List())
  }

  test("get lucky with Cuerno del Comandante"){
    val p1: Player = new Player("p1", 1, List(), List(commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn))
    val p2: Player = new Player("p2", 1, List(), List(commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn, commanderHorn))
    for (i <- 1 to p1.getHand.length){p1.playCard(commanderHorn, partida)}
    for (i <- 1 to p2.getHand.length){p2.playCard(commanderHorn, partida)}
    assertEquals(p1.getHand, List())
    assertEquals(p2.getHand, List())
  }

}