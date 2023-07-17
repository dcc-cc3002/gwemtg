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
    val geraltOfRivia: CloseCombatCard = CloseCombatCard("Geralt of Rivia", "vainilla", 5)
    val yenneferOfVengerberg: RangedCombatCard = RangedCombatCard("Yennefer of Vengerberg", "refuerzo_moral", 3)
    val ciri: RangedCombatCard = RangedCombatCard("Ciri", "vainilla", 4)
    val vesemir: SiegeCombatCard = SiegeCombatCard("Vesemir", "vinculo_estrecho", 5)
    val dandelion: SiegeCombatCard = SiegeCombatCard("Dandelion", "vinculo_estrecho", 3)
    val trissMerigold: CloseCombatCard = CloseCombatCard("Triss Merigold", "vainilla", 5)
    val yen: RangedCombatCard = RangedCombatCard("Yen", "vainilla", 6)
    val eskel: CloseCombatCard = CloseCombatCard("Eskel", "refuerzo_moral", 3)
    val lambert: SiegeCombatCard = SiegeCombatCard("Lambert", "vainilla", 6)
    val zoltanChivay: CloseCombatCard = CloseCombatCard("Zoltan Chivay", "refuerzo_moral", 4)
    /** 5 ClimateCards para el juego */
    val bitingFrost: WeatherCard = new WeatherCard("Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de mele a 1")
    val impenetrableFog: WeatherCard = new WeatherCard("Niebla Impenetrable", "Aplica niebla a una fila enemiga.")
    val torrentialRain: WeatherCard = new WeatherCard("LLuvia Torrencial", "Aplica lluvia a una fila enemiga.")
    val clearWeather: WeatherCard = new WeatherCard("Despejar", "Limpia todos los efectos de clima del campo de batalla.")
    val commanderHorn: WeatherCard = new WeatherCard("Cuerno del Comandante", "Dobla la fuerza de todas las unidades de una fila.")

    /** list of cards in this, the first version of gwent */
    val coleccion: List[Card] = List(geraltOfRivia, yenneferOfVengerberg, ciri, vesemir, dandelion, trissMerigold, yen, eskel, lambert, zoltanChivay, bitingFrost, impenetrableFog, torrentialRain, clearWeather, commanderHorn)

    for (i <- 1 to 25) {
      output = output :+ coleccion(rand.nextInt(coleccion.length))
    }

    output
  }
}
