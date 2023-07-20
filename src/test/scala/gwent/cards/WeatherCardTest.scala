package cl.uchile.dcc
package gwent.cards


import gwent.cards.*
import munit.*

class WeatherCardTest extends munit.FunSuite {
  var bitingFrost: WeatherCard = _
  var impenetrableFog: WeatherCard = _
  var torrentialRain: WeatherCard = _
  var clearWeather: WeatherCard = _
  var commanderHorn: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    bitingFrost = new WeatherCard("Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de melee a 1")
    impenetrableFog = new WeatherCard("Niebla Impenetrable", "Convierte el valor de fuerza de todas las cartas de rango a 1.")
    torrentialRain = new WeatherCard("LLuvia Torrencial", "Convierte el valor de fuerza de todas las cartas de asedio a 1.")
    clearWeather = new WeatherCard("Despejar", "Limpia todos los efectos de clima del campo de batalla.")
    commanderHorn = new WeatherCard("Cuerno del Comandante", "Dobla la fuerza de todas las unidades de una fila propia al azar.")

  }

  test("test for Equals"){
    assertEquals(bitingFrost, new WeatherCard("Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de melee a 1"))
  }

  test("test for getters") {
    assertEquals(bitingFrost.getName, "Escarcha mordiente")
    assertEquals(bitingFrost.getDescription, "Convierte el valor de fuerza de todas las cartas de melee a 1")
    assertEquals(impenetrableFog.getName, "Niebla Impenetrable")
    assertEquals(impenetrableFog.getDescription, "Convierte el valor de fuerza de todas las cartas de rango a 1.")
    assertEquals(torrentialRain.getName, "LLuvia Torrencial")
    assertEquals(torrentialRain.getDescription, "Convierte el valor de fuerza de todas las cartas de asedio a 1.")
    assertEquals(clearWeather.getName, "Despejar")
    assertEquals(clearWeather.getDescription, "Limpia todos los efectos de clima del campo de batalla.")
    assertEquals(commanderHorn.getName, "Cuerno del Comandante")
    assertEquals(commanderHorn.getDescription, "Dobla la fuerza de todas las unidades de una fila propia al azar.")
  }

  /** getPower
   * getPower returns the power of the card
   * weather cards have no power
   * therefore, getPower returns 0
   */
  def getPower: Int = 0

}
