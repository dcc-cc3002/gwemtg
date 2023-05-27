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
  var eskel: UnitCarta = new UnitCarta("Eskel", 5, 1, 3)
  var ciri: UnitCarta = new UnitCarta("Ciri", 7, 2, 4)
  var lambert: UnitCarta = new UnitCarta("Lambert", 6, 3, 6)
  var ladoP1: Side = new Side(List(), List(), List())
  var ladoP2: Side = new Side(List(eskel),List(ciri),List(lambert))


  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Carta("Carta 0")
    uno = new Carta("Carta 1")
    dos = new Carta("Carta 2")
    tres = new Carta("Carta 3")
    jugador = new Player("Hugo", List(uno, dos))
    npc = new ComputerPlayer("Marvin", List(cero, uno))
    eskel = new UnitCarta("Eskel", 5, 1, 3)
    ciri = new UnitCarta("Ciri", 7, 2, 4)
    lambert = new UnitCarta("Lambert", 6, 3, 6)
    ladoP1 = new Side(List(), List(), List())
    ladoP2 = new Side(List(eskel),List(ciri),List(lambert))
  }

  test("test para equals") {
    var l1: Side = new Side(List(), List(), List())
    var l2: Side = new Side(List(eskel),List(ciri),List(lambert))
    ladoP1 equals l1
    l1 equals ladoP1
    ladoP2 equals l2
    l2 equals ladoP2
  }


}
