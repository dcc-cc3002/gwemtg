package cl.uchile.dcc
package gwent.SideTest

import gwent.Board.*
import gwent.Side.*
import gwent.Player.*
import gwent.Carta.*
import munit.*


class SideTest  extends munit.FunSuite {
  var cero: Carta = new Carta("Carta 0")
  var uno: Carta = new Carta("Carta 1")
  var dos: Carta = new Carta("Carta 2")
  var tres: Carta = new Carta("Carta 3")
  var jugador: Player = new Player("Hugo", List(uno, dos))
  var npc: ComputerPlayer = new ComputerPlayer("Marvin", List(cero, uno))

  var ladoP1: Side = new Side(List(), List(), List())
  var ladoP2: Side = new Side(List(), List(), List())


  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Carta("Carta 0")
    uno = new Carta("Carta 1")
    dos = new Carta("Carta 2")
    tres = new Carta("Carta 3")
    jugador = new Player("Hugo", List(uno, dos))
    npc = new ComputerPlayer("Marvin", List(cero, uno))

    var ladoP1: Side = new Side(List(), List(), List())
    var ladoP2: Side = new Side(List(), List(), List())
  }

}
