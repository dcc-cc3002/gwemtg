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
  override def beforeEach(context: BeforeEach): Unit = {
    cero = Card("Card 0")
    uno = Card("Card 1")
    dos = Card("Card 2")
  }


    test("test para equals") {}

  test("Card debe tener nommbre"){
    val test: Card = new Card("Test")
    val test1: Card = new Card("Card 1")
    assertEquals(test.getName(),"Test")
    assertEquals(test1.getName(), uno.getName())
  }

  test("UnitCard debe tener fuerza, coste, tipo y efectos acertados") {
    val geralt: UnitCard = new UnitCard("Geralt", 8, "mele", 6, List())
    assertEquals(geralt.getName(), "Geralt")
    assertEquals(geralt.fuerza, 8)
    assertEquals(geralt.coste, 6)
    assertEquals(geralt.tipo, "mele")
    assertEquals(geralt.efectos, List())
  }

  test("ClimateCard debe tener coste y efectos acertados") {
    val escarchaMordiente: ClimateCard = new ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    assertEquals(escarchaMordiente.getName(), "Escarcha mordiente")
    assertEquals(escarchaMordiente.coste, 1)
    assertEquals(escarchaMordiente.efectos, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  }

}

/* este es el constructor de un carta de criatura o 'unidad' 
class UnitCard(nombre: String, var fuerza: Int, val tipo: String, var coste: Int, val efectos: List[String]) extends AbstractCard{
}

 este es el constructor de una carta climatica
class ClimateCard(nombre: String, var coste: Int, val efectos: List[String]) extends AbstractCard{
}
 */