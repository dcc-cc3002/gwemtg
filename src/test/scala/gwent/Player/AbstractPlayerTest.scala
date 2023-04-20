package cl.uchile.dcc
package gwent.Player

/**
 * AbstractPlayerTest
 *
 * Tests para la clase AbstractPlayerTest que representa jugadores tanto humanos como no
 *
 * @author Hugo Diaz
 * @since 1.1.0
 * @version 1.1.3
 */

import gwent.Card.*
import gwent.Player.*

import munit.*
//import munit.Clue.generate

class AbstractPlayerTest extends munit.FunSuite {

  var cero: Card = new Card("Card 0")
  var uno: Card = new Card("Card 1")
  var dos: Card = new Card("Card 2")
  var tres: Card = new Card("Card 3")
  var jugador: Player = new Player("Hugo", List(uno, dos))
  var npc: ComputerPlayer = new ComputerPlayer("Marvin", List(cero, uno))


  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Card("Card 0")
    uno = new Card("Card 1")
    dos = new Card("Card 2")
    tres = new Card("Card 3")
    jugador = new Player("Hugo", List(uno,dos))
    npc = new ComputerPlayer("Marvin", List(cero,uno))
  }


  test("test para equals") {
    val p1: Player = p1(("Hugo", List(uno,dos)))
    val p2: ComputerPlayer = p2("Marvin", List(cero,uno))
    p1.equals(jugador)
    p2.equals(jugador)
    jugador.equals(p1)
    jugador.equals(p2)
}


  test("crear un jugador humano con un mazo y un nombre deberia tener los mismos atributos que los puestos"){
    val esperado: AbstractPlayer = new Player("Hugo", List(uno, dos))
    assertEquals(jugador.name, esperado.name,"los nombres no coinciden")
    assertEquals(jugador.deck, esperado.deck,"los mazos no coinciden")
  }

  test("crear un jugador automata con un mazo y un nombre deberia tener los mismos atributos que los puestos"){
    val esperado = new ComputerPlayer("Marvin", List(cero,uno))
    assertEquals(npc.name, esperado.name,"los nombres no coinciden")
    assertEquals(npc.deck, esperado.deck,"los mazos no coinciden")
  }

  test("anxadir una carta sobre el mazo de un jugador deberia aumentar su tamanxo y quedar al principio"){
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, 0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.head, tres, "la carta no fue anxadida arriba")
    assertEquals(jugador.deck(0), tres, "la carta no fue anxadida arriba")
    assertEquals(jugador.deck, List(tres, uno, dos), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio"){
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, -1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.last, tres, "la carta no fue anxadida abajo")
    assertEquals(jugador.deck(jugador.deck.length-1), tres, "la carta no fue anxadida abajo")
    assertEquals(jugador.deck, List(uno, dos, tres), "los mazos no coinciden")
    }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, 1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(1), tres, "la carta fue anxadida en el indice 1")
    assertEquals(jugador.deck, List(uno, tres, dos), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.length, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, -2)
    assertEquals(jugador.deck.length, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(jugador.deck.length - 2), tres, "la carta no fue anxadida en el indice -2")
    assertEquals(jugador.deck, List(uno, tres, dos), "los mazos no coinciden")
  }


    test("robar una carta al mazo del jugador deberia disminuir su tamanxo y termimnar siendo mas pequenxo"){
      assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
      val robada : Card = jugador.draw()
      //assertEquals(type(robada), Card, "carta robada es tipo carta")
      assertEquals(robada,uno,"no se robo la carta esperada 'uno'")
      assertEquals(jugador.deck.size, 1, "mazo de distinto tamanxo al esperado")
    }

  /*
  test("Player should start with 2 gems and an empty hand") {
    val player = new Player("Alice")
    assertEquals(player.health, 10)
      assertEquals(player.hand, List())
      assertEquals(player.hand.size, 0)
  }
  */
}
