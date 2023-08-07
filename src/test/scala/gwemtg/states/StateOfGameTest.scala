package hugodiazroa
package gwemtg

import gwemtg.cards.*
import gwemtg.board.*
import gwemtg.Player

import munit.*

class StateOfGameTest extends munit.FunSuite {

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
    troop1 = new CloseCombatCard("troop1", "pedro", 1, 1)
    troop2 = new CloseCombatCard("troop2", "pablo", 2, 2)
    troop3 = new CloseCombatCard("troop3", "jose", 3, 3)

    ranged1 = new RangedCombatCard("ranged1", "eliana", 1, 1)
    ranged2 = new RangedCombatCard("ranged2", "maria", 2, 2)
    ranged3 = new RangedCombatCard("ranged3", "alia", 3, 3)

    catapult1 = new SiegeCombatCard("catapult1", "isis", 1, 1)
    catapult2 = new SiegeCombatCard("catapult2", "dracula", 2, 2)
    catapult3 = new SiegeCombatCard("catapult3", "atenea", 3, 3)

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







}