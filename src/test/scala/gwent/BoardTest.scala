package cl.uchile.dcc
package gwent

import gwent.cards.*
import gwent.Player

import munit.*

class BoardTest extends munit.FunSuite {

  /** 10 UnitCards para el juego */
  var geraltOfRivia: CloseCombatCard = CloseCombatCard("Geralt of Rivia", 5, 5)
  var yenneferOfVengerberg: RangedCombatCard = RangedCombatCard("Yennefer of Vengerberg", 4, 7)
  var ciri: RangedCombatCard = RangedCombatCard("Ciri", 7, 4)
  var vesemir: SiegeCombatCard = SiegeCombatCard("Vesemir", 3, 5)
  var dandelion: SiegeCombatCard = SiegeCombatCard("Dandelion", 2, 7)
  var trissMerigold: CloseCombatCard = CloseCombatCard("Triss Merigold", 6, 5)
  var yen: RangedCombatCard = RangedCombatCard("Yen", 7, 6)
  var eskel: CloseCombatCard = CloseCombatCard("Eskel", 5, 3)
  var lambert: SiegeCombatCard = SiegeCombatCard("Lambert", 6, 6)
  var zoltanChivay: CloseCombatCard = CloseCombatCard("Zoltan Chivay", 4, 4)
  /** 5 ClimateCards para el juego */
  var bitingFrost: WeatherCard = new WeatherCard("Escarcha mordiente", 1, "Convierte el valor de fuerza de todas las cartas de mele a 1")
  var impenetrableFog: WeatherCard = new WeatherCard("Niebla Impenetrable", 2, "Aplica niebla a una fila enemiga.")
  var torrentialRain: WeatherCard = new WeatherCard("LLuvia Torrencial", 3, "Aplica lluvia a una fila enemiga.")
  var clearWeather: WeatherCard = new WeatherCard("Despejar", 1, "Limpia todos los efectos de clima del campo de batalla.")
  var commanderHorn: WeatherCard = new WeatherCard("Cuerno del Comandante", 4, "Dobla la fuerza de todas las unidades de una fila.")

  /** tablero vacio */
  val tablero: Board = new Board()

  /** jugadores a testear */
  var jugador1: Player = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))
  var jugador2: Player = new Player("Lain", 2, List(vesemir, dandelion, trissMerigold, yen, eskel), List(lambert, zoltanChivay, bitingFrost))

  override def beforeEach(context: BeforeEach): Unit = {
    geraltOfRivia = new CloseCombatCard("Geralt of Rivia", 5, 5)
    yenneferOfVengerberg = new RangedCombatCard("Yennefer of Vengerberg", 4, 7)
    ciri = new RangedCombatCard("Ciri", 7, 4)
    vesemir = new SiegeCombatCard("Vesemir", 3, 5)
    dandelion = new SiegeCombatCard("Dandelion", 2, 7)
    trissMerigold = new CloseCombatCard("Triss Merigold", 6, 5)
    yen = new RangedCombatCard("Yen", 7, 6)
    eskel = new CloseCombatCard("Eskel", 5, 3)
    lambert = new SiegeCombatCard("Lambert", 6, 6)
    zoltanChivay = new CloseCombatCard("Zoltan Chivay", 4, 4)
    bitingFrost = new WeatherCard("Escarcha mordiente", 1, "Convierte el valor de fuerza de todas las cartas de mele a 1")
    impenetrableFog = new WeatherCard("Niebla Impenetrable", 2, "Aplica niebla a una fila enemiga.")
    torrentialRain = new WeatherCard("LLuvia Torrencial", 3, "Aplica lluvia a una fila enemiga.")
    clearWeather = new WeatherCard("Despejar", 1, "Limpia todos los efectos de clima del campo de batalla.")
    commanderHorn = new WeatherCard("Cuerno del Comandante", 4, "Dobla la fuerza de todas las unidades de una fila.")

    jugador1 = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))
    jugador2 = new Player("Lain", 2, List(vesemir, dandelion, trissMerigold, yen, eskel), List(lambert, zoltanChivay, bitingFrost))
  }


  test("test para equals") {
    val tablero_vacio: Board = new Board()
    assertEquals(tablero, tablero_vacio)
  }

}
