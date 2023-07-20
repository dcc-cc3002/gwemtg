package cl.uchile.dcc
package gwent

import gwent.Game
import gwent.board.*
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

  var climate1: WeatherCard = _
  var climate2: WeatherCard = _

  var jugador: Player = _
  var jugador2: Player = _

  var partida: Game = _

  var tablero1: Board = new Board()


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

    climate1 = new WeatherCard("climate1", "lluvia")
    climate2 = new WeatherCard("climate2", "nieve")

    jugador = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2, climate2))
    jugador2 = new Player("Lain", 2, List(), List())

    partida = new Game(tablero1, jugador, jugador)

    tablero1 = new Board()

  }


  test("test para equals") {
    val p1: Player = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2, climate2))
    val p2: Player = new Player("Lain", 2, List(), List())
    assertEquals(p1,jugador)
    assertEquals(jugador,p1)
    assertNotEquals(p1,p2)

  }

  test("un jugador tiene bien su hashCode y debe poder ser comparado con canEqual") {
    val p1: Player = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2, climate2))
    assert(p1.canEqual(jugador))
    assert(jugador.canEqual(p1))
    assertEquals(p1.hashCode, jugador.hashCode)

  }


  test("test para getHand") {
    assertEquals(jugador.getHand, List(troop2, ranged2, catapult2, climate2))
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

  test("tests for playing cards of all types") {
    assertEquals(partida.getP1.getHand, List(troop2, ranged2, catapult2, climate2))
    assertEquals(partida.board.p1m.hashCode(), new MeleeZone().hashCode())
    jugador.playCard(troop2, partida)
    assertEquals(partida.getP1.getHand, List(ranged2, catapult2, climate2))
    assertEquals(partida.board.p1m.hashCode(), new MeleeZone(List(troop2)).hashCode())

    assertEquals(partida.board.p1r.hashCode(), new RangeZone().hashCode())
    partida.getP1.playCard(ranged2, partida)
    assertEquals(partida.getP1.getHand, List(catapult2, climate2))
    assertEquals(partida.board.p1r.hashCode(), new RangeZone(List(ranged2)).hashCode())

    assertEquals(partida.board.clima.hashCode(), new ClimateZone().hashCode())
    partida.getP1.playCard(climate2, partida)
    assertEquals(partida.getP1.getHand, List(catapult2))
    assertEquals(partida.board.clima.hashCode(), new ClimateZone(List(climate2)).hashCode())

    assertEquals(partida.board.p1s.hashCode(), new MarginalZone().hashCode())
    partida.getP1.playCard(catapult2, partida)
    assertEquals(partida.getP1.getHand, List())
    assertEquals(partida.board.p1s.hashCode(), new MarginalZone(List(catapult2)).hashCode())
  }


  test("test pt 2 for playing cards: player 2") {

    val partida2: Game = new Game(new Board(), jugador2, jugador)

    assertEquals(partida2.getP2.getHand, List(troop2, ranged2, catapult2, climate2))
    assertEquals(partida2.board.p2m.hashCode(), new MeleeZone().hashCode())
    partida2.getP2.playCard(troop2, partida2)
    assertEquals(partida2.getP2.getHand, List(ranged2, catapult2, climate2))
    assertEquals(partida2.board.p2m.hashCode(), new MeleeZone(List(troop2)).hashCode())

    assertEquals(partida2.board.p2r.hashCode(), new RangeZone().hashCode())
    partida2.getP2.playCard(ranged2, partida2)
    assertEquals(partida2.getP2.getHand, List(catapult2, climate2))
    assertEquals(partida2.board.p2r.hashCode(), new RangeZone(List(ranged2)).hashCode())

    assertEquals(partida2.board.clima.hashCode(), new ClimateZone().hashCode())
    partida2.getP2.playCard(climate2, partida2)
    assertEquals(partida2.getP2.getHand, List(catapult2))
    assertEquals(partida2.board.clima.hashCode(), new ClimateZone(List(climate2)).hashCode())

    assertEquals(partida2.board.p2s.hashCode(), new MarginalZone().hashCode())
    partida2.getP2.playCard(catapult2, partida2)
    assertEquals(partida2.getP2.getHand, List())
    assertEquals(partida2.board.p2s.hashCode(), new MarginalZone(List(catapult2)).hashCode())
  }

  test("test for remove card: removeCard"){
    assertEquals(jugador.getHand, List(troop2, ranged2, catapult2, climate2))
    jugador.removeCard(troop2)
    assertEquals(jugador.getHand, List(ranged2, catapult2, climate2))
  }
  test("deckToString and hand print"){
//    assertEquals(jugador.deckToString, "CloseCombatCard: troop1, pedro, 1 CloseCombatCard: troop3, jose, 3 RangedCombatCard: ranged1, eliana, 1 RangedCombatCard: ranged3, alia, 3 SiegeCombatCardcatapult1, isis, 1 SiegeCombatCardcatapult3, atenea, 3\n")
//  values are not equal even if they have the same `toString()`: CloseCombatCard: troop1, pedro, 1 CloseCombatCard: troop3, jose, 3 RangedCombatCard: ranged1, eliana, 1 RangedCombatCard: ranged3, alia, 3 SiegeCombatCardcatapult1, isis, 1 SiegeCombatCardcatapult3, atenea, 3
    assertEquals(jugador2.deckToString, "\n")
    assertEquals(jugador2.handPrint, "\n")
    }

  test("test for hasClimate"){
    assertEquals(jugador.hasClimate, true)
    jugador.playCard(climate2, partida)
    assertEquals(jugador.hasClimate, false)
  }

  test("test for loseGem"){
    assertEquals(jugador.gemCounter, 2)
    jugador.loseGem()
    assertEquals(jugador.gemCounter, 1)
  }

}
