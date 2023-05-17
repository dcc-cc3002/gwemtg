package cl.uchile.dcc
package gwent.BoardTest

import gwent.Board.*
import gwent.Side.*
import gwent.Player.*
import gwent.Carta.*
import munit.*
import munit.Clue.generate

class BoardTest extends munit.FunSuite {
  var cero: Carta = new Carta("Carta 0")
  var uno: Carta = new Carta("Carta 1")
  var dos: Carta = new Carta("Carta 2")
  var tres: Carta = new Carta("Carta 3")
  var jugador: Player = new Player("Hugo", List(uno, dos))
  var npc: ComputerPlayer = new ComputerPlayer("Marvin", List(cero, uno))

  var ladoP1: Side = new Side(List(),List(),List())
  var ladoP2: Side = new Side(List(),List(),List())
  var bitingFrost: ClimateCarta = new ClimateCarta("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  var board: Board = new Board(ladoP1,bitingFrost,ladoP2)

  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Carta("Carta 0")
    uno = new Carta("Carta 1")
    dos = new Carta("Carta 2")
    tres = new Carta("Carta 3")
    jugador = new Player("Hugo", List(uno, dos))
    npc = new ComputerPlayer("Marvin", List(cero, uno))
    ladoP1 = new Side(List(),List(),List())
    ladoP2 = new Side(List(),List(),List())
    bitingFrost = ClimateCarta("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
    board = new Board(ladoP1,bitingFrost,ladoP2)

  }

}
