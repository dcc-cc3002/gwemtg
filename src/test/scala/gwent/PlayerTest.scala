package cl.uchile.dcc
package gwent
package cards


import gwent.*

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
  var bitingFrost: ClimateCard = new ClimateCard("Escarcha mordiente", 1, List("Convierte el valor de fuerza de todas las cartas de mele a 1"))
  var impenetrableFog: ClimateCard = new ClimateCard("Niebla Impenetrable", 2, List("Aplica niebla a una fila enemiga."))
  var torrentialRain: ClimateCard = new ClimateCard("LLuvia Torrencial", 3, List("Aplica lluvia a una fila enemiga."))
  var clearWeather: ClimateCard = new ClimateCard("Despejar", 1, List("Limpia todos los efectos de clima del campo de batalla."))
  var commanderHorn: ClimateCard = new ClimateCard("Cuerno del Comandante", 4, List("Dobla la fuerza de todas las unidades de una fila."))
}
