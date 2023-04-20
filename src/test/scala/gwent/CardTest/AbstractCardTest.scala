package cl.uchile.dcc
package gwent.CardTest

/**
 * CardTest
 *
 * Tests para la clase Card
 *
 * lorem ipsum
 * sit dolore atem
 *
 * @author Hugo Diaz
 * @since 1.1.0
 * @version 1.1.3
 */

import gwent.Card.*
import munit.*

class AbstractCardTest extends FunSuite {

  var cero: Card = new Card("Card 0")
  var uno: Card = new Card("Card 1")
  var dos: Card = new Card("Card 2")

  /** 10 UnitCards para el juego */
  var geraltOfRivia: UnitCard = UnitCard("Geralt of Rivia", 5, 1, 5)
  var yenneferOfVengerberg: UnitCard = UnitCard("Yennefer of Vengerberg", 4, 2, 7)
  var ciri: UnitCard = UnitCard("Ciri", 7, 2, 4)
  var vesemir: UnitCard = UnitCard("Vesemir", 3, 3, 5)
  var dandelion: UnitCard = UnitCard("Dandelion", 2, 3, 7)
  var trissMerigold: UnitCard = UnitCard("Triss Merigold", 6, 1, 5)
  var yen: UnitCard = UnitCard("Yen", 7, 5, 6)
  var eskel: UnitCard = UnitCard("Eskel", 5, 1, 3)
  var lambert: UnitCard = UnitCard("Lambert", 6, 3, 6)
  var zoltanChivay: UnitCard = UnitCard("Zoltan Chivay", 4, 1, 4)
  /** 5 ClimateCards for para el juego */
  var bitingFrost: ClimateCard = new ClimateCard("Biting Frost", 1, List("Apply Frost to an enemy row."))
  var impenetrableFog: ClimateCard = new ClimateCard("Impenetrable Fog", 2, List("Apply Fog to an enemy row."))
  var torrentialRain: ClimateCard = new ClimateCard("Torrential Rain", 3, List("Apply Rain to an enemy row."))
  var clearWeather: ClimateCard = new ClimateCard("Clear Weather", 1, List("Clear all weather effects from the board."))
  var commanderHorn: ClimateCard = new ClimateCard("Commander's Horn", 4, List("Double the strength of all units on a row."))


  override def beforeEach(context: BeforeEach): Unit = {
    cero = Card("Card 0")
    uno = Card("Card 1")
    dos = Card("Card 2")
    geraltOfRivia = UnitCard("Geralt of Rivia", 5, 1, 5)
    yenneferOfVengerberg = UnitCard("Yennefer of Vengerberg", 4, 2, 7)
    ciri = UnitCard("Ciri", 7, 2, 4)
    vesemir = UnitCard("Vesemir", 3, 3, 5)
    dandelion = UnitCard("Dandelion", 2, 3, 7)
    trissMerigold = UnitCard("Triss Merigold", 6, 1, 5)
    yen = UnitCard("Yen", 7, 5, 6)
    eskel = UnitCard("Eskel", 5, 1, 3)
    lambert = UnitCard("Lambert", 6, 3, 6)
    zoltanChivay = UnitCard("Zoltan Chivay", 4, 1, 4)
    bitingFrost = ClimateCard("Biting Frost", 1, List("Apply Frost to an enemy row."))
    impenetrableFog = ClimateCard("Impenetrable Fog", 2, List("Apply Fog to an enemy row."))
    torrentialRain = ClimateCard("Torrential Rain", 3, List("Apply Rain to an enemy row."))
    clearWeather = ClimateCard("Clear Weather", 1, List("Clear all weather effects from the board."))
    commanderHorn = ClimateCard("Commander's Horn", 4, List("Double the strength of all units on a row."))

  }



  

  test("Card debe tener nombre"){
    val test: Card = new Card("Test")
    val test1: Card = new Card("Card 1")
    assertEquals(test.getName(),"Test")
    assertEquals(test1.getName(), uno.getName())
  }

  /*
  test("UnitCard debe tener fuerza, coste, tipo y efectos acertados") {
    val geralt: UnitCard = new UnitCard("Geralt", 8, 1, 6, List())
    assertEquals(geralt.getName(), "Geralt")
    assertEquals(geralt.fuerza, 8)
    assertEquals(geralt.coste, 6)
    assertEquals(geralt.tipo, 1)
    assertEquals(geralt.efectos, List())
  }
  */
  /*
  test("ClimateCard debe tener coste y efectos acertados") {
    val escarchaMordiente: ClimateCard = new ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    assertEquals(escarchaMordiente.getName(), "Escarcha mordiente")
    assertEquals(escarchaMordiente.coste, 1)
    assertEquals(escarchaMordiente.efectos, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  }
  */
}

/* este es el constructor de un carta de criatura o 'unidad' 
class UnitCard(nombre: String, var fuerza: Int, val tipo: String, var coste: Int, val efectos: List[String]) extends AbstractCard{
}

 este es el constructor de una carta climatica
class ClimateCard(nombre: String, var coste: Int, val efectos: List[String]) extends AbstractCard{
}
 */