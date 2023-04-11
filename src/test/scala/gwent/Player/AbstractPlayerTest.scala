package cl.uchile.dcc
package gwent.Player


import munit._

class AbstractPlayerTest extends munit.FunSuite
{

  override def beforeEach(context: BeforeEach): Unit =
  {
    val jugador = new Player("Hugo", List(Card("Card 1"), Card("Card 2")))
    val npc = new ComputerPlayer("Marvin", List(Card("Card 0"), Card("Card 1")))
  }
  test("crear un jugador humano con un mazo y un nombre deberia tener los mismos atributos que los puestos")
  {
    assertEquals(jugador.name, "Hugo","los nombres no coinciden")
    assertEquals(player.deck, List(Card("Card 1"), Card("Card 2")),"los mazos no coinciden")
  }

  test("crear un jugador automata con un mazo y un nombre deberia tener los mismos atributos que los puestos")
  {
    assertEquals(player.name, "Marvin","los nombres no coinciden")
    assertEquals(player.deck, List(Card("Card 0"), Card("Card 1")),"los mazos no coinciden")
  }

  test("anxadir una carta sobre el mazo de un jugador deberia aumentar su tamanxo y quedar al principio")
  {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.deck = jugador.deck.add(Card("Card 3"),0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(player.deck, List(Card("Card 3")), Card("Card 1"), Card("Card 2"), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio")
  {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.deck = jugador.deck.add(Card("Card 3"), 0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(player.deck, List(Card("Card 1"), Card("Card 2"), Card("Card 3")), "los mazos no coinciden")
  }

  test("robar una carta al mazo del jugador deberia disminuir su tamanxo y termimnar siendo mas pequenxo")
  {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    robada = jugador.deck.pop()
    assertEquals(type(robada), Card, "carta robada es tipo carta")
    assertEquals(robada,Card("Card 1"),"no se robo la carta esperada 'Card 1'")
    assertEquals(jugador.deck.size, 1, "mazo de distinto tamanxo al esperado")
  }
}
