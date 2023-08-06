package cl.uchile.dcc
package gwent

import gwent.cards.*


/** DeckBuilder
 * DeckBulder is a factory for [[cl.uchile.dcc.gwent.Deck]]s.
 *
 * it has the method buildDeck() that returns a [[cl.uchile.dcc.gwent.Deck]].
 */
class DeckBuilder {
  /** buildDeck
   * ***** Cada jugador cuenta con un mazo de 25 cartas de cualquier clasificación
   * @return a [[cl.uchile.dcc.gwent.Deck]] with 25 cards.
   */
  def buildDeck(): List[Card] = {
    var output = List[Card]()
    val rand = new scala.util.Random
    /** 10 UnitCards para el juego */   
    /** refuerzo moral: otorga un bonus de +1 a cada carta de su mismo tipo en el campo de batalla */
    /** vinculo estrecho: duplica la fuerza de las cartas tocayas en su zona */
    
    val vorstclaw: CloseCombatCard = CloseCombatCard("Vorstclaw", "vainilla", 7, 6)
    val grizzledOutrider: CloseCombatCard = CloseCombatCard("Grizzled Outrider", "vainilla", 5, 5)
    val goblinKing: CloseCombatCard = CloseCombatCard("Goblin King", "refuerzo_moral", 3, 3)
    val battleCryGoblin: CloseCombatCard = CloseCombatCard("Battle Cry Goblin", "refuerzo_moral", 2, 2)
    
    val yen: RangedCombatCard = RangedCombatCard("Yen", "vainilla", 6 , 5)
    val ciri: RangedCombatCard = RangedCombatCard("Ciri", "vainilla", 4, 3)
    val yenneferOfVengerberg: RangedCombatCard = RangedCombatCard("Yennefer of Vengerberg", "refuerzo_moral", 3, 3)

    val lambert: SiegeCombatCard = SiegeCombatCard("Lambert", "vainilla", 6, 5)
    val vesemir: SiegeCombatCard = SiegeCombatCard("Vesemir", "vinculo_estrecho", 5, 5)
    val dandelion: SiegeCombatCard = SiegeCombatCard("Dandelion", "vinculo_estrecho", 3, 3)
    
    /** 5 ClimateCards para el juego */
    val bitingFrost: WeatherCard = new WeatherCard("Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de melee a 1")
    val impenetrableFog: WeatherCard = new WeatherCard("Niebla Impenetrable", "Convierte el valor de fuerza de todas las cartas de rango a 1.")
    val torrentialRain: WeatherCard = new WeatherCard("LLuvia Torrencial", "Convierte el valor de fuerza de todas las cartas de asedio a 1.")
    val clearWeather: WeatherCard = new WeatherCard("Despejar", "Limpia todos los efectos de clima del campo de batalla.")
    val commanderHorn: WeatherCard = new WeatherCard("Cuerno del Comandante", "Dobla la fuerza de todas las unidades de una fila propia al azar.")

    /** list of cards in this, the first version of gwent */
    val coleccion: List[Card] = List(geraltOfRivia, yenneferOfVengerberg, ciri, vesemir, dandelion, trissMerigold, yen, eskel, lambert, zoltanChivay, bitingFrost, impenetrableFog, torrentialRain, clearWeather, commanderHorn)

    for (i <- 1 to 25) {
      output = output :+ coleccion(rand.nextInt(coleccion.length))
    }

    output
  }
}
