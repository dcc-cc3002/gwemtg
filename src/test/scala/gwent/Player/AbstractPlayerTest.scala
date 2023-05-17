package cl.uchile.dcc
package gwent
package Player

/**
 * AbstractPlayerTest
 *
 * Tests para la clase AbstractPlayerTest que representa jugadores tanto humanos como no
 *
 * @author Hugo Diaz
 * @since 1.1.0
 * @version 2.1.0
 */


import munit.*


class AbstractPlayerTest extends munit.FunSuite {
  var cero: Carta = new Carta("Carta 0")
  var uno: Carta = new Carta("Carta 1")
  var dos: Carta = new Carta("Carta 2")
  var tres: Carta = new Carta("Carta 3")
  var jugador: Player = new Player("Hugo", List(uno, dos))
  var npc: ComputerPlayer = new ComputerPlayer("Marvin", List(cero, uno))


  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Carta("Carta 0")
    uno = new Carta("Carta 1")
    dos = new Carta("Carta 2")
    tres = new Carta("Carta 3")
    jugador = new Player("Hugo", List(uno,dos))
    npc = new ComputerPlayer("Marvin", List(cero,uno))
  }


  test("test para equals") {
    val p1: Player = Player("Hugo", List(uno,dos))
    val p2: ComputerPlayer = ComputerPlayer("Marvin", List(cero,uno))
    p1.equals(jugador)
    p2.equals(npc)
    jugador.equals(p1)
    npc.equals(p2)
    assert(!(p1.equals(p2)))
  }

  test("un jugador tiene bien su hashCode y debe poder ser comparado con canEqual") {
    val p1: Player = Player("Hugo", List(uno, dos))
    val p2: ComputerPlayer = ComputerPlayer("Marvin", List(cero, uno))
    assertEquals(p1.## , jugador.##)
    assertEquals(p2.## , npc.##)
    assert(p1.canEqual(jugador))
    assert(jugador.canEqual(p1))
    assert(p2.canEqual(npc))
    assert(npc.canEqual(p2))
  }

    test("un jugador tiene bien puestas su mano, campo de battalla y mazo iniciales"){
    val listaVacia: List[Carta] = List()
    assertEquals(jugador.getSide, (List(),List(),List()), "campo no es igual a campoVacio")
    assertEquals(jugador.getHand, listaVacia, "mano no es igual a lista vacia")
    assertEquals(jugador.getGems, 2, "vida inicial distinta de dos")
    assertEquals(jugador.initialDeckSize, 25, "tamanxo de mazo inicial distinto a 25")
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

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al final"){
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, -1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.last, tres, "la carta no fue anxadida abajo")
    assertEquals(jugador.deck(jugador.deck.length-1), tres, "la carta no fue anxadida abajo")
    assertEquals(jugador.deck, List(uno, dos, tres), "los mazos no coinciden")
  }

  test("anxadir una carta en la posicion 1 del mazo deberia quedar segunda") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, 1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(1), tres, "la carta fue anxadida en el indice 1")
    assertEquals(jugador.deck, List(uno, tres, dos), "los mazos no coinciden")
  }

  test("anxadir una carta en la posicion -2 del mazo deberia quedar penultima") {
    assertEquals(jugador.deck.length, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, -2)
    assertEquals(jugador.deck.length, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(jugador.deck.length - 2), tres, "la carta no fue anxadida en el indice -2")
    assertEquals(jugador.deck, List(uno, tres, dos), "los mazos no coinciden")
  }

  test("robar una carta al mazo del jugador deberia disminuir su tamanxo y terminar siendo mas pequenxo"){
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    val robada : Carta = jugador.draw()
    assertEquals(robada,uno,"no se robo la carta esperada 'uno'")
    assertEquals(jugador.deck.size, 1, "mazo de distinto tamanxo al esperado")
  }

  test("anxadir una carta al mazo deberia aumentar su tamanxo y las cartas deberian ser las originales"){
    val jugadorSinCartas : Player = new Player("Lain",List())
    assertEquals(jugadorSinCartas.deck.length, 0, "mazo deberia estar vacio")
    jugadorSinCartas.cardInDeck(uno)
    assertEquals(jugadorSinCartas.deck.length, 1, "mazo deberia tener  una carta")
    jugadorSinCartas.cardInDeck(dos)
    assertEquals(jugadorSinCartas.deck.length, 2, "mazo deberia tener  dos cartas")
    jugadorSinCartas.cardInDeck(tres)
    assertEquals(jugadorSinCartas.deck.length, 3, "mazo deberia tener tres cartas")
  }

  test("string bonitos"){
    assertEquals(jugador.toString,"Player( nombre=Hugo, mazo=List(Carta(nombre=Carta 1), Carta(nombre=Carta 2)) )")
    assertEquals(npc.toString,"ComputerPlayer( nombre=Marvin, mazo=List(Carta(nombre=Carta 0), Carta(nombre=Carta 1)) )")
  }

}
