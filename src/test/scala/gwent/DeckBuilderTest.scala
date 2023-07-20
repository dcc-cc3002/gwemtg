package cl.uchile.dcc
package gwent

class DeckBuilderTest extends munit.FunSuite{
  val deckBuilder = new DeckBuilder()
  test("DeckBuilder builds a deck of 25 cards"){
    val deck = deckBuilder.buildDeck()
    assert(deck.size == 25)
  }
  test("draw an initial hand"){
    val deck = deckBuilder.buildDeck()
    var jugador = new Player("Jugador", 2, deck, List())
    assert(jugador.getHand.size == 0)
    assert(jugador.getDeck.size == 25)
    jugador.drawInitialHand()
    assert(jugador.getHand.size == 10)
    assert(jugador.getDeck.size == 15)
  }
}
