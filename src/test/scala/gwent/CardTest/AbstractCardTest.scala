package cl.uchile.dcc
package gwent.CardTest

/**
 * CardTest
 *
 * Tests para la clase Card
 *
 * @author Hugo Diaz
 * @since 1.1.0
 * @version 2.1.0
 */

import munit.Clue.generate

import gwent.Card.Card
import gwent.Card.ClimateCard
import gwent.Card.UnitCard
import munit.*


class AbstractCardTest extends FunSuite {
  /** tres cartas Card para el juego */
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
  /** 5 ClimateCards para el juego */
  var bitingFrost: ClimateCard = new ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  var impenetrableFog: ClimateCard = new ClimateCard("Niebla Impenetrable", 2, List("Aplica niebla a una fila enemiga."))
  var torrentialRain: ClimateCard = new ClimateCard("LLuvia Torrencial", 3, List("Aplica lluvia a una fila enemiga."))
  var clearWeather: ClimateCard = new ClimateCard("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
  var commanderHorn: ClimateCard = new ClimateCard("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))


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
    bitingFrost = ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    impenetrableFog = ClimateCard("Niebla Impenetrable", 2, List("Aplica niebla a una fila enemiga."))
    torrentialRain = ClimateCard("LLuvia Torrencial", 3, List("Aplica lluvia a una fila enemiga."))
    clearWeather = ClimateCard("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
    commanderHorn = ClimateCard("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))

  }

  test("Card equls Card"){
    val dos2: Card = new Card("Card 2")
    dos2.canEqual(dos)
    assertEquals(dos2.## , dos.##)
    dos.equals(dos2)
    dos2.equals(dos)
    assert(!dos2.equals(vesemir))
  }

  test("Card equls UnitCard") {
    val yen2: UnitCard = new UnitCard("Yen", 7, 5, 6)
    yen2.canEqual(yen)
    assertEquals(yen2.##, yen.##)
    yen.equals(yen2)
    yen2.equals(yen)
    assert(!yen2.equals(vesemir))
    assert(!yen.equals(vesemir))
    assert (!vesemir.equals(yen2))
    assert(!vesemir.equals(yen))
  }

  test ("Card equls ClimateCard") {
    val ch2: ClimateCard = new ClimateCard("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))
    ch2.canEqual(commanderHorn)
    assertEquals(ch2.##, commanderHorn.##)
    commanderHorn.equals(ch2)
    ch2.equals(commanderHorn)
    assert(!ch2.equals(vesemir))
    assert(!commanderHorn.equals(vesemir))
  }

  test("las cartas debe tener nombre"){
    val test: Card = new Card("Test")
    val test1: Card = new Card("Card 1")
    val triss2: UnitCard = new UnitCard("Triss Merigold", 6, 1, 5)
    val cw2: ClimateCard = new ClimateCard("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
    assertEquals(test.getName,"Test")
    assertEquals(test1.getName, uno.getName)
    assertEquals(triss2.getName, "Triss Merigold")
    assertEquals(triss2.getName, trissMerigold.getName)
    assertEquals(cw2.getName, "Despejar")
    assertEquals(cw2.getName, clearWeather.getName)
  }


  test("UnitCard debe tener fuerza, coste, tipo y efectos acertados") {
    val geralt: UnitCard = new UnitCard("Geralt of Rivia", 5, 1, 5, List())
    assertEquals(geralt.getName, "Geralt of Rivia")
    assertEquals(geralt.fuerza, 5)
    assertEquals(geralt.coste, 5)
    assertEquals(geralt.tipo, 1)
    assertEquals(geralt.efectos, List())
    assertEquals(geralt.getName, geraltOfRivia.getName)
    assertEquals(geralt.fuerza, geraltOfRivia.fuerza)
    assertEquals(geralt.coste, geraltOfRivia.coste)
    assertEquals(geralt.tipo, geraltOfRivia.tipo)
    assertEquals(geralt.efectos, geraltOfRivia.efectos)
  }


  test("ClimateCard debe tener nombre, coste y efectos acertados") {
    val escarchaMordiente: ClimateCard = new ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    assertEquals(escarchaMordiente.getName, "Escarcha mordiente","getName contra texto")
    assertEquals(escarchaMordiente.coste, 1,"coste contra entero")
    assertEquals(escarchaMordiente.efectos, List("Convierte el valor de fuerza de todas las cartas de mele a 1"), "efectos contra lista de cadenas")
    assertEquals(escarchaMordiente.getName, bitingFrost.getName, "getName contra bitingFrost.getName()")
    assertEquals(escarchaMordiente.coste, bitingFrost.coste, "coste contra bitingFrost.coste")
    assertEquals(escarchaMordiente.efectos, bitingFrost.efectos, "efectos contra bitingFrost.efectos")
  }

  test("string bonitos") {
    assertEquals(dos.toString ,"Card(nombre=Card 2)")
    assertEquals(eskel.toString , "UnitCard(nombre=Eskel)")
    assertEquals(torrentialRain.toString , "ClimateCard(nombre=LLuvia Torrencial)")
  }
}
