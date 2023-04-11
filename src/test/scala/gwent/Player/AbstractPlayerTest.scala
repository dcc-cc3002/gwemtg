package cl.uchile.dcc
package gwent.Player


import cl.uchile.dcc.gwent.Card.Card
import munit.*

class AbstractPlayerTest extends munit.FunSuite
{
  val cero: Card = null
  val uno: Card = null
  val dos: Card = null
  val tres: Card = null
  val robada: Card = null

  var jugador: Player = null
  var npc: ComputerPlayer = null
  override def beforeEach(context: BeforeEach): Unit =
  {
    val cero = new Card("Card 0")
    val uno = new Card("Card 1")
    val dos = new Card("Card 2")
    val tres = new Card("Card 3")
    var jugador = new Player("Hugo", List(uno,dos))
    var npc = new ComputerPlayer("Marvin", List(cero,uno))
  }

  test("crear un jugador humano con un mazo y un nombre deberia tener los mismos atributos que los puestos")
  {
    var esperado = new Player("Hugo", List(uno,dos))
    assertEquals(jugador.name, esperado.name,"los nombres no coinciden")
    assertEquals(jugador.deck, esperado.deck,"los mazos no coinciden")
  }
/*
  test("crear un jugador automata con un mazo y un nombre deberia tener los mismos atributos que los puestos")
  {
    var esperado = new ComputerPlayer("Marvin", List(cero,uno))
    assertEquals(npc.name, esperado.name,"los nombres no coinciden")
    assertEquals(npc.deck, esperado.deck,"los mazos no coinciden")
  }
*/
/*
  test("anxadir una carta sobre el mazo de un jugador deberia aumentar su tamanxo y quedar al principio")
  {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.deck = jugador.deck.add(Card("Card 3"),0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck, List(Card("Card 3")), Card("Card 1"), Card("Card 2"), "los mazos no coinciden")
  }
*/
/*
  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio")
  {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.deck = jugador.deck.add(Card("Card 3"), 0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck, List(Card("Card 1"), Card("Card 2"), Card("Card 3")), "los mazos no coinciden")
  }
*/
/*
  test("robar una carta al mazo del jugador deberia disminuir su tamanxo y termimnar siendo mas pequenxo")
  {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    robada = jugador.deck.pop()
    //assertEquals(type(robada), Card, "carta robada es tipo carta")
    assertEquals(robada,Card("Card 1"),"no se robo la carta esperada 'Card 1'")
    assertEquals(jugador.deck.size, 1, "mazo de distinto tamanxo al esperado")
  }
*/

}
