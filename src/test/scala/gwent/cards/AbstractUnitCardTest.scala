package cl.uchile.dcc
package gwent.cards

import gwent.cards.*

import munit.*

class AbstractUnitCardTest extends munit.FunSuite {
  /** 10 UnitCards para el juego */
  var geraltOfRivia: CloseCombatCard = CloseCombatCard("Geralt of Rivia", 5, 5)
  var yenneferOfVengerberg: RangedCombatCard = RangedCombatCard("Yennefer of Vengerberg", 4, 7)
  var xiri: CloseCombatCard = CloseCombatCard("Xiri", 7, 4)
  var vesemir: SiegeCombatCard = SiegeCombatCard("Vesemir", 3, 5)
  var dandelion: SiegeCombatCard = SiegeCombatCard("Dandelion", 2, 7)
  var trissMerigold: CloseCombatCard = CloseCombatCard("Triss Merigold", 6, 5)
  var yen: RangedCombatCard = RangedCombatCard("Yen", 7, 6)
  var eskel: CloseCombatCard = CloseCombatCard("Eskel", 5, 3)
  var lambert: SiegeCombatCard = SiegeCombatCard("Lambert", 6, 6)
  var zoltanChivay: SiegeCombatCard = SiegeCombatCard("Zoltan Chivay", 4, 4)

  override def beforeEach(context: BeforeEach): Unit = {
    geraltOfRivia = new CloseCombatCard("Geralt of Rivia", 5, 5)
    yenneferOfVengerberg = new RangedCombatCard("Yennefer of Vengerberg", 4, 7)
    xiri = new CloseCombatCard("Xiri", 7, 4)
    vesemir = new SiegeCombatCard("Vesemir", 3, 5)
    dandelion = new SiegeCombatCard("Dandelion", 2, 7)
    trissMerigold = new CloseCombatCard("Triss Merigold", 6, 5)
    yen = new RangedCombatCard("Yen", 7, 6)
    eskel = new CloseCombatCard("Eskel", 5, 3)
    lambert = new SiegeCombatCard("Lambert", 6, 6)
    zoltanChivay = new SiegeCombatCard("Zoltan Chivay", 4, 4)
  }



  test("test para equals") {
    val x = new CloseCombatCard("Xiri", 7, 4)
    val y = new RangedCombatCard("Yen", 7, 6)
    val z = new SiegeCombatCard("Zoltan Chivay", 4, 4)
    assertEquals(x,xiri)
    assertEquals(y,yen)
    assertEquals(z,zoltanChivay)
  }

  test("una carta tiene bien su hashCode y debe poder ser comparado con canEqual") {
    val x = new CloseCombatCard("Xiri", 7, 4)
    val y = new RangedCombatCard("Yen", 7, 6)
    val z = new SiegeCombatCard("Zoltan Chivay", 4, 4)
    assertEquals(x.##, xiri.##)
    assert(x.canEqual(xiri))
    assert(xiri.canEqual(x))
    assertEquals(y.##, yen.##)
    assert(y.canEqual(yen))
    assert(yen.canEqual(y))
    assertEquals(z.##, zoltanChivay.##)
    assert(z.canEqual(zoltanChivay))
    assert(zoltanChivay.canEqual(z))
  }

}
