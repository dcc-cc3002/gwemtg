 package cl.uchile.dcc
package gwent.cards


import gwent.cards.*
import munit.*

class double_D3Test extends munit.FunSuite {
  var bitingFrost: WeatherCard = _
  var impenetrableFog: WeatherCard = _
  var torrentialRain: WeatherCard = _
  var clearWeather: WeatherCard = _
  var commanderHorn: WeatherCard = _
  val yenneferOfVengerberg: RangedCombatCard = RangedCombatCard("Yennefer of Vengerberg", "refuerzo_moral", 3)

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

  test("test for not Equals"){
    assertNotEquals(bitingFrost, impenetrableFog)
    assert(bitingFrost != commanderHorn)
    assert(bitingFrost != yenneferOfVengerberg)
  }

  test("test for toString"){
    assertEquals(bitingFrost.toString, "WeatherCard: Escarcha mordiente, Convierte el valor de fuerza de todas las cartas de melee a 1")
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

  test("test for getPower"){
    assertEquals(bitingFrost.getPower, 0)
    assertEquals(impenetrableFog.getPower, 0)
    assertEquals(torrentialRain.getPower, 0)
    assertEquals(clearWeather.getPower, 0)
    assertEquals(commanderHorn.getPower, 0)
  }

}
