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
 * @version 1.1.2
 */

import gwent.Card.*
import munit.*

class CardTest extends FunSuite {
  test("UnitCard debe tener fuerza, coste, tipo y efectos acertados") {
    val geralt: UnitCard = new UnitCard("Geralt", 8, "mele", 6, List())
    assertEquals(geralt.nombre, "Geralt")
    assertEquals(geralt.fuerza, 8)
    assertEquals(geralt.coste, 6)
    assertEquals(geralt.tipo, "mele")
    assertEquals(geralt.efectos, List())
  }

  test("ClimateCard debe tener coste y efectos acertados") {
    val escarchaMordiente: ClimateCard = new ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    assertEquals(escarchaMordiente.nombre, "Escarcha mordiente")
    assertEquals(escarchaMordiente.coste, 1)
    assertEquals(escarchaMordiente.efectos, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  }

                       /*
  test("") {
    val board = new Board
    val card = new UnitCard("Card 1", 1, 1, 1)
    board.addCard(card)
    assertEquals(board.size, 1)
    board.removeCard(card)
    assertEquals(board.size, 0)}     */

}