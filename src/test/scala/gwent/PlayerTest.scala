package cl.uchile.dcc
package gwent


import gwent.cards.*
import munit.*

class PlayerTest extends munit.FunSuite {
  /** 10 UnitCards para el juego */
  var geraltOfRivia: CloseCombatCard = CloseCombatCard("Geralt of Rivia", 5, 5)
  var yenneferOfVengerberg: RangedCombatCard = RangedCombatCard("Yennefer of Vengerberg", 4, 7)
  var ciri: RangedCombatCard = RangedCombatCard("Ciri", 7, 4)
  var vesemir: SiegeCombatCard = SiegeCombatCard("Vesemir", 3, 5)
  var dandelion: SiegeCombatCard = SiegeCombatCard("Dandelion", 2, 7)
  var trissMerigold: CloseCombatCard = CloseCombatCard("Triss Merigold", 6, 5)
  var yen: RangedCombatCard = RangedCombatCard("Yen", 7, 6)
  var eskel: CloseCombatCard = CloseCombatCard("Eskel", 5, 3)
  var lambert: SiegeCombatCard = SiegeCombatCard("Lambert", 6, 6)
  var zoltanChivay: CloseCombatCard = CloseCombatCard("Zoltan Chivay", 4, 4)
  /** 5 ClimateCards para el juego */
  var bitingFrost: WeatherCard = new WeatherCard("Escarcha mordiente", 1, "Convierte el valor de fuerza de todas las cartas de mele a 1")
  var impenetrableFog: WeatherCard = new WeatherCard("Niebla Impenetrable", 2, "Aplica niebla a una fila enemiga.")
  var torrentialRain: WeatherCard = new WeatherCard("LLuvia Torrencial", 3, "Aplica lluvia a una fila enemiga.")
  var clearWeather: WeatherCard = new WeatherCard("Despejar", 1, "Limpia todos los efectos de clima del campo de batalla.")
  var commanderHorn: WeatherCard = new WeatherCard("Cuerno del Comandante", 4, "Dobla la fuerza de todas las unidades de una fila.")

  /** jugador a testear*/
  var jugador: Player = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))

  override def beforeEach(context: BeforeEach): Unit = {
    geraltOfRivia = new CloseCombatCard("Geralt of Rivia", 5, 5)
    yenneferOfVengerberg = new RangedCombatCard("Yennefer of Vengerberg", 4, 7)
    ciri = new RangedCombatCard("Ciri", 7, 4)
    vesemir = new SiegeCombatCard("Vesemir", 3, 5)
    dandelion = new SiegeCombatCard("Dandelion", 2, 7)
    trissMerigold = new CloseCombatCard("Triss Merigold", 6, 5)
    yen = new RangedCombatCard("Yen", 7, 6)
    eskel = new CloseCombatCard("Eskel", 5, 3)
    lambert = new SiegeCombatCard("Lambert", 6, 6)
    zoltanChivay = new CloseCombatCard("Zoltan Chivay", 4, 4)
    bitingFrost = new WeatherCard("Escarcha mordiente", 1, "Convierte el valor de fuerza de todas las cartas de mele a 1")
    impenetrableFog = new WeatherCard("Niebla Impenetrable", 2, "Aplica niebla a una fila enemiga.")
    torrentialRain = new WeatherCard("LLuvia Torrencial", 3, "Aplica lluvia a una fila enemiga.")
    clearWeather = new WeatherCard("Despejar", 1, "Limpia todos los efectos de clima del campo de batalla.")
    commanderHorn = new WeatherCard("Cuerno del Comandante", 4, "Dobla la fuerza de todas las unidades de una fila.")

    jugador = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))
  }


  test("test para equals") {
    val p1: Player = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))
    val p2: Player = new Player("Lain", 2, List(), List())
    p1.equals(jugador)
    jugador.equals(p1)
    assert(!(p1.equals(p2)))
  }

  test("un jugador tiene bien su hashCode y debe poder ser comparado con canEqual") {
    val p1: Player = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))
    assertEquals(p1.##, jugador.##)
    assert(p1.canEqual(jugador))
    assert(jugador.canEqual(p1))
  }

  /*
  test("un jugador tiene bien puestas su mano, campo de battalla y mazo iniciales") {
    val listaVacia: List[Card] = List()
    assertEquals(jugador.getSide, (List(), List(), List()), "campo no es igual a campoVacio")
    assertEquals(jugador.getHand, listaVacia, "mano no es igual a lista vacia")
    assertEquals(jugador.getGems, 2, "vida inicial distinta de dos")
    assertEquals(jugador.initialDeckSize, 25, "tamanxo de mazo inicial distinto a 25")
  }
  */

  test("crear un jugador humano con un mazo y un nombre deberia tener los mismos atributos que los puestos") {
    val p1: Player = new Player("Hugo", 2, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), List(eskel, lambert, commanderHorn))
    assertEquals(jugador.name, p1.name, "los nombres no coinciden")
    assertEquals(jugador.gemCounter, p1.gemCounter, "los contadores de gemas no coinciden")
    assertEquals(jugador.deck, p1.deck, "los mazos no coinciden")
    assertEquals(jugador.hand, p1.hand, "las manos no coinciden")
  }

/*

  test("anxadir una carta sobre el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(lambert, 0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.head, lambert, "la carta no fue anxadida arriba")
    //assertEquals(jugador.deck(0), tres, "la carta no fue anxadida arriba")
    assertEquals(jugador.deck, List(lambert, geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al final") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(lambert, -1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.last, lambert, "la carta no fue anxadida abajo")
    //assertEquals(jugador.deck(jugador.deck.length - 1), tres, "la carta no fue anxadida abajo")
    assertEquals(jugador.deck, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, clearWeather, lambert), "los mazos no coinciden")
  }

  test("anxadir una carta en la posicion 1 del mazo deberia quedar segunda") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(lambert, 1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(1), lambert, "la carta fue anxadida en el indice 1")
    assertEquals(jugador.deck, List(geraltOfRivia, lambert, yenneferOfVengerberg, ciri, torrentialRain, clearWeather), "los mazos no coinciden")
  }

  test("anxadir una carta en la posicion -2 del mazo deberia quedar penultima") {
    assertEquals(jugador.deck.length, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(lambert, -2)
    assertEquals(jugador.deck.length, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(jugador.deck.length - 2), lambert, "la carta no fue anxadida en el indice -2")
    assertEquals(jugador.deck, List(geraltOfRivia, yenneferOfVengerberg, ciri, torrentialRain, lambert, clearWeather), "los mazos no coinciden")
  }
*/

  test("robar una carta al mazo del jugador deberia disminuir su tamanxo y terminar siendo mas pequenxo") {
    assertEquals(jugador.deck.size, 5, "mazo de distinto tamanxo al esperado")
    val robada: Card = jugador.drawCard()
    assertEquals(robada, geraltOfRivia, "no se robo la carta esperada 'uno'")
    assertEquals(jugador.deck.size, 4, "mazo de distinto tamanxo al esperado")
  }

  test("anxadir una carta al mazo deberia aumentar su tamanxo y las cartas deberian ser las originales") {
    val jugadorSinCartas: Player = new Player("Lain", 2, List(), List(yenneferOfVengerberg, ciri, torrentialRain))
    assertEquals(jugadorSinCartas.deck.length, 0, "mazo deberia estar vacio")
    jugadorSinCartas.cardInDeck(yenneferOfVengerberg)
    assertEquals(jugadorSinCartas.deck.length, 1, "mazo deberia tener  una carta")
    jugadorSinCartas.cardInDeck(ciri)
    assertEquals(jugadorSinCartas.deck.length, 2, "mazo deberia tener  dos cartas")
    jugadorSinCartas.cardInDeck(torrentialRain)
    assertEquals(jugadorSinCartas.deck.length, 3, "mazo deberia tener tres cartas")
  }
}
