package cl.uchile.dcc
package gwent


import gwent.cards.*
import munit.*

class PlayerTest extends munit.FunSuite {
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

  override def beforeEach(context: BeforeEach): Unit = {
    geraltOfRivia = CloseCombatCard("Geralt of Rivia", 5, 5)
    yenneferOfVengerberg = RangedCombatCard("Yennefer of Vengerberg", 4, 7)
    ciri = RangedCombatCard("Ciri", 7, 4)
    vesemir = SiegeCombatCard("Vesemir", 3, 5)
    dandelion = SiegeCombatCard("Dandelion", 2, 7)
    trissMerigold = CloseCombatCard("Triss Merigold", 6, 5)
    yen = RangedCombatCard("Yen", 7, 6)
    eskel = CloseCombatCard("Eskel", 5, 3)
    lambert = SiegeCombatCard("Lambert", 6, 6)
    zoltanChivay = CloseCombatCard("Zoltan Chivay", 4, 4)
    bitingFrost = new WeatherCard("Escarcha mordiente", 1, "Convierte el valor de fuerza de todas las cartas de mele a 1")
    impenetrableFog = new WeatherCard("Niebla Impenetrable", 2, "Aplica niebla a una fila enemiga.")
    torrentialRain = new WeatherCard("LLuvia Torrencial", 3, "Aplica lluvia a una fila enemiga.")
    clearWeather = new WeatherCard("Despejar", 1, "Limpia todos los efectos de clima del campo de batalla.")
    commanderHorn = new WeatherCard("Cuerno del Comandante", 4, "Dobla la fuerza de todas las unidades de una fila.")

  }

}
