package cl.uchile.dcc
package gwent.CartaTest

/**
 * CartaTest
 *
 * Tests para la clase Carta
 *
 * @author Hugo Diaz
 * @since 1.1.0
 * @version 2.1.1
 */

import gwent.Carta.*
import munit.*


class CartaTest extends FunSuite {
  /** tres cartas Carta para el juego */
  var cero: Carta = new Carta("Carta 0")
  var uno: Carta = new Carta("Carta 1")
  var dos: Carta = new Carta("Carta 2")
  /** 10 UnitCards para el juego */
  var geraltOfRivia: UnitCarta = new UnitCarta("Geralt of Rivia", 5, 1, 5)
  var yenneferOfVengerberg: UnitCarta = new UnitCarta("Yennefer of Vengerberg", 4, 2, 7)
  var ciri: UnitCarta = new UnitCarta("Ciri", 7, 2, 4)
  var vesemir: UnitCarta = new UnitCarta("Vesemir", 3, 3, 5)
  var dandelion: UnitCarta = new UnitCarta("Dandelion", 2, 3, 7)
  var trissMerigold: UnitCarta = new UnitCarta("Triss Merigold", 6, 1, 5)
  var yen: UnitCarta = new UnitCarta("Yen", 7, 5, 6)
  var eskel: UnitCarta = new UnitCarta("Eskel", 5, 1, 3)
  var lambert: UnitCarta = new UnitCarta("Lambert", 6, 3, 6)
  var zoltanChivay: UnitCarta = new UnitCarta("Zoltan Chivay", 4, 1, 4)
  /** 5 ClimateCards para el juego */
  var bitingFrost: ClimateCarta = new ClimateCarta("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  var impenetrableFog: ClimateCarta = new ClimateCarta("Niebla Impenetrable", 2, List("Aplica niebla a una fila enemiga."))
  var torrentialRain: ClimateCarta = new ClimateCarta("LLuvia Torrencial", 3, List("Aplica lluvia a una fila enemiga."))
  var clearWeather: ClimateCarta = new ClimateCarta("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
  var commanderHorn: ClimateCarta = new ClimateCarta("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))


  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Carta("Carta 0")
    uno = new Carta("Carta 1")
    dos = new Carta("Carta 2")
    geraltOfRivia = new UnitCarta("Geralt of Rivia", 5, 1, 5)
    yenneferOfVengerberg = new UnitCarta("Yennefer of Vengerberg", 4, 2, 7)
    ciri = new UnitCarta("Ciri", 7, 2, 4)
    vesemir = new UnitCarta("Vesemir", 3, 3, 5)
    dandelion = new UnitCarta("Dandelion", 2, 3, 7)
    trissMerigold = new UnitCarta("Triss Merigold", 6, 1, 5)
    yen = new UnitCarta("Yen", 7, 5, 6)
    eskel = new UnitCarta("Eskel", 5, 1, 3)
    lambert = new UnitCarta("Lambert", 6, 3, 6)
    zoltanChivay = new UnitCarta("Zoltan Chivay", 4, 1, 4)
    bitingFrost = new ClimateCarta("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    impenetrableFog = new ClimateCarta("Niebla Impenetrable", 2, List("Aplica niebla a una fila enemiga."))
    torrentialRain = new ClimateCarta("LLuvia Torrencial", 3, List("Aplica lluvia a una fila enemiga."))
    clearWeather = new ClimateCarta("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
    commanderHorn = new ClimateCarta("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))

  }

  test("Carta equls Carta"){
    val dos2: Carta = new Carta("Carta 2")
    dos2.canEqual(dos)
    assertEquals(dos2.## , dos.##)
    dos.equals(dos2)
    dos2.equals(dos)
    assert(!dos2.equals(vesemir))
  }

  test("Carta equls UnitCarta") {
    val yen2: UnitCarta = new UnitCarta("Yen", 7, 5, 6)
    yen2.canEqual(yen)
    assertEquals(yen2.##, yen.##)
    yen.equals(yen2)
    yen2.equals(yen)
    assert(!yen2.equals(vesemir))
    assert(!yen.equals(vesemir))
    assert (!vesemir.equals(yen2))
    assert(!vesemir.equals(yen))
  }

  test ("Carta equls ClimateCarta") {
    val ch2: ClimateCarta = new ClimateCarta("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))
    ch2.canEqual(commanderHorn)
    assertEquals(ch2.##, commanderHorn.##)
    commanderHorn.equals(ch2)
    ch2.equals(commanderHorn)
    assert(!ch2.equals(vesemir))
    assert(!commanderHorn.equals(vesemir))
  }

  test("las cartas debe tener nombre"){
    val test: Carta = new Carta("Test")
    val test1: Carta = new Carta("Carta 1")
    val triss2: UnitCarta = new UnitCarta("Triss Merigold", 6, 1, 5)
    val cw2: ClimateCarta = new ClimateCarta("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
    assertEquals(test.getName,"Test")
    assertEquals(test1.getName, uno.getName)
    assertEquals(triss2.getName, "Triss Merigold")
    assertEquals(triss2.getName, trissMerigold.getName)
    assertEquals(cw2.getName, "Despejar")
    assertEquals(cw2.getName, clearWeather.getName)
  }


  test("UnitCarta debe tener fuerza, coste, tipo y efectos acertados") {
    val geralt: UnitCarta = new UnitCarta("Geralt of Rivia", 5, 1, 5, List())
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


  test("ClimateCarta debe tener nombre, coste y efectos acertados") {
    val escarchaMordiente: ClimateCarta = new ClimateCarta("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    assertEquals(escarchaMordiente.getName, "Escarcha mordiente","getName contra texto")
    assertEquals(escarchaMordiente.coste, 1,"coste contra entero")
    assertEquals(escarchaMordiente.efectos, List("Convierte el valor de fuerza de todas las cartas de mele a 1"), "efectos contra lista de cadenas")
    assertEquals(escarchaMordiente.getName, bitingFrost.getName, "getName contra bitingFrost.getName()")
    assertEquals(escarchaMordiente.coste, bitingFrost.coste, "coste contra bitingFrost.coste")
    assertEquals(escarchaMordiente.efectos, bitingFrost.efectos, "efectos contra bitingFrost.efectos")
  }

  test("string bonitos") {
    assertEquals(dos.toString ,"Carta(nombre=Carta 2)")
    assertEquals(eskel.toString , "UnitCarta(nombre=Eskel)")
    assertEquals(torrentialRain.toString , "ClimateCarta(nombre=LLuvia Torrencial)")
  }
}
