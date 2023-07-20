package cl.uchile.dcc
package gwent.cards


import gwent.cards.*
import munit.*

class CloseCombatCardTest extends munit.FunSuite  {
  var troop1: CloseCombatCard = new CloseCombatCard("troop1", "pedro", 1)
  var troop2: CloseCombatCard = new CloseCombatCard("troop2", "pablo", 2)
  var troop3: CloseCombatCard = new CloseCombatCard("troop3", "jose", 3)

  var ranged1: RangedCombatCard = new RangedCombatCard("ranged1", "eliana", 1)
  var ranged2: RangedCombatCard = new RangedCombatCard("ranged2", "maria", 2)
  var ranged3: RangedCombatCard = new RangedCombatCard("ranged3", "alia", 3)

  var catapult1: SiegeCombatCard = new SiegeCombatCard("catapult1", "isis", 1)
  var catapult2: SiegeCombatCard = new SiegeCombatCard("catapult2", "dracula", 2)
  var catapult3: SiegeCombatCard = new SiegeCombatCard("catapult3", "atenea", 3)

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
  }

  test("test for equals") {
    val tropauno: CloseCombatCard = new CloseCombatCard("troop1", "pedro", 1)
    assertEquals(troop1, tropauno, "two cards with the same name, description and power should be equal")
    assertNotEquals(troop1, troop2, "two cards with different name, description or power should not be equal")
    assertEquals(troop1, troop1, "a card should be equal to itself")
    assertNotEquals(troop2, troop1, "two cards with different name, description or power should not be equal")

  }

  test("test for hashcode") {
    val tropauno: CloseCombatCard = new CloseCombatCard("troop1", "pedro", 1)
    assertEquals(troop1.hashCode(), tropauno.hashCode(), "two cards with the same name, description and power should have the same hashcode")
    assertNotEquals(troop1.hashCode(), troop2.hashCode(), "two cards with different name, description or power should not have the same hashcode")
    assertEquals(troop1.hashCode(), troop1.hashCode(), "a card should have the same hashcode as itself")
    assert(tropauno.canEqual(troop1), "two cards with the same name, description and power should be able to be compared")
    assert(troop1.canEqual(tropauno), "two cards with the same name, description and power should be able to be compared")
  }

  test("test for getters") {
    assertEquals(troop1.getName, "troop1")
    assertEquals(troop1.getDescription, "pedro")
    assertEquals(troop1.getPower, 1)
    assertEquals(troop1.getOGPower, 1)
  }

  test("test for setPower"){
    assertEquals(troop1.getPower, 1)
    troop1.setPower(2)
    assertEquals(troop1.getPower, 2)
    assertEquals(troop1.getOGPower, 1)
  }

}