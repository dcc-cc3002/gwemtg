package cl.uchile.dcc
package gwent

import gwent.cards.*
import munit.*

class PlayerTest extends munit.FunSuite{
  var troop1: CloseCombatCard = _
  var troop2: CloseCombatCard = _
  var troop3: CloseCombatCard = _

  var ranged1: RangedCombatCard = _
  var ranged2: RangedCombatCard = _
  var ranged3: RangedCombatCard = _

  var catapult1: SiegeCombatCard = _
  var catapult2: SiegeCombatCard = _
  var catapult3: SiegeCombatCard = _

  var jugador: Player = _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CloseCombatCard("troop1", "pedro", 1)
    troop2 = new CloseCombatCard("troop2", "pablo", 2)
    troop3 = new CloseCombatCard("troop3", "jose", 3)

    ranged1 = new RangedCombatCard("ranged1", "eliana", 1)
    ranged2 = new RangedCombatCard("ranged2", "maria", 2)
    ranged3 = new RangedCombatCard("ranged3", "alia", 3)

    catapult1 = new SiegeCombatCard("catapult1", "isis", 1)
    catapult2 = new SiegeCombatCard("catapult2", "dracula", 2)
    catapult3 = new SiegeCombatCard("catapult3", "atenea", 3)

    jugador = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))

  }


  test("test para equals") {
    val p1: Player = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    val p2: Player = new Player("Lain", 2, List(), List())
    p1.equals(jugador)
    jugador.equals(p1)
    assert(!(p1.equals(p2)))
  }

  test("un jugador tiene bien su hashCode y debe poder ser comparado con canEqual") {
    val p1: Player = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
    assert(p1.canEqual(jugador))
    assert(jugador.canEqual(p1))
    assertEquals(p1.hashCode, jugador.hashCode)

  }


  test("test para getHand") {
    assertEquals(jugador.getHand, List(troop2, ranged2, catapult2))
  }

  test("test para getDeck") {
    assertEquals(jugador.getDeck, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3))
  }



  test("anxadir una carta sobre el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.size, 6, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(troop2, 0)
    assertEquals(jugador.deck.size, 7, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.head, troop2, "la carta no fue anxadida arriba")
    assertEquals(jugador.deck, List(troop2, troop1, troop3, ranged1, ranged3, catapult1, catapult3), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al final") {
    assertEquals(jugador.deck.size, 6, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(troop2, -1)
    assertEquals(jugador.deck.size, 7, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.last, troop2, "la carta no fue anxadida abajo")
    assertEquals(jugador.deck, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3, troop2), "los mazos no coinciden")
  }

  test("anxadir una carta en la posicion 1 del mazo deberia quedar segunda") {
    assertEquals(jugador.deck.size, 6, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(troop2, 1)
    assertEquals(jugador.deck.size, 7, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(1), troop2, "la carta fue anxadida en el indice 1")
    assertEquals(jugador.deck, List(troop1, troop2, troop3, ranged1, ranged3, catapult1, catapult3), "los mazos no coinciden")
  }

  test("anxadir una carta en la posicion -2 del mazo deberia quedar penultima") {
    assertEquals(jugador.deck.length, 6, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(troop2, -2)
    assertEquals(jugador.deck.length, 7, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(jugador.deck.length - 2), troop2, "la carta no fue anxadida en el indice -2")
    assertEquals(jugador.deck, List(troop1, troop3, ranged1, ranged3, catapult1, troop2, catapult3), "los mazos no coinciden")
  }


  test("robar una carta al mazo del jugador deberia disminuir su tamanxo y terminar siendo mas pequenxo") {
    assertEquals(jugador.deck.size, 6, "mazo de distinto tamanxo al esperado")
    val robada: Card = jugador.drawCard()
    assertEquals(robada, troop1, "no se robo la carta esperada 'troop1'")
    assertEquals(jugador.deck.size, 5, "mazo de distinto tamanxo al esperado")
  }

  test("anxadir una carta al mazo deberia aumentar su tamanxo y las cartas deberian ser las originales") {
    val jugadorSinCartas: Player = new Player("Lain", 2, List(), List(troop1, troop2, troop3))
    assertEquals(jugadorSinCartas.deck.length, 0, "mazo deberia estar vacio")
    jugadorSinCartas.cardInDeck(troop1)
    assertEquals(jugadorSinCartas.deck.length, 1, "mazo deberia tener  una carta")
    jugadorSinCartas.cardInDeck(troop2)
    assertEquals(jugadorSinCartas.deck.length, 2, "mazo deberia tener  dos cartas")
    jugadorSinCartas.cardInDeck(troop3)
    assertEquals(jugadorSinCartas.deck.length, 3, "mazo deberia tener tres cartas")
  }
}
