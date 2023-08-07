package hugodiazroa
package gwemtg.effects

/**
 * set_power_of_row_to_x
 * this trait extends the WheatherCard class
 * it sets a row from 1 to 3 to an interger value (bigger that zero)
 */

import gwemtg.{Game, Player}
import gwemtg.board.*
import gwemtg.cards.*



trait set_power_of_zone_to_x(row: Int, x: Int) extends WeatherCard {
  override def effect(player: Player, game: Game): Unit = {
    if (player == game.getP1) {
      row match {
        case 1 => for (card <- game.board.p1m.data) card.setPower(x)
        case 2 => for (card <- game.board.p1r.data) card.setPower(x)
        case 3 => for (card <- game.board.p1s.data) card.setPower(x)
      }
    } else if (player == game.getP2) {
      row match {
        case 1 => for (card <- game.board.p2m.data) card.setPower(x)
        case 2 => for (card <- game.board.p2r.data) card.setPower(x)
        case 3 => for (card <- game.board.p2s.data) card.setPower(x)
      }
    }
  }

}

/*
/** * RangedCombatCardEffect
 * function that applies the effect of a ranged combat card
 * there are 3 possible effects:
 * refuerzo_moral: adds 1 power to all other cards in the same row
 * vinculo_estrecho: duplicates the power of any card in the same row with the same name
 * vainilla: no effect
 */
def RangedCombatCardEffect(cartita: Card, p: Player): Unit = {
  val name = cartita.description
  name match
    case "refuerzo_moral" =>
      if p == this.Player1 then for (card <- board.p1r.data) {
        card.setPower(card.getPower + 1)
      }
      else if p == this.Player2 then for (card <- board.p2r.data) {
        card.setPower(card.getPower + 1)
      }

    case "vinculo_estrecho" =>
      if (p == this.Player1) {
        for (card <- board.p1r.data) {
          if (card.getName == cartita.getName) {
            card.setPower(card.getPower * 2)
          }
        }
      } else if (p == this.Player2) {
        for (card <- board.p2r.data) {
          if (card.getName == cartita.getName) {
            card.setPower(card.getPower * 2)
          }
        }
      }

    case _ =>
}

/** CloseCombatCardEffect
 * function that applies the effect of a close combat card
 * there are 3 possible effects:
 * refuerzo_moral: adds 1 power to all other cards in the same row
 * vinculo_estrecho: duplicates the power of any card in the same row with the same name
 * vainilla: no effect
 */
def CloseCombatCardEffect(cartita: Card, p: Player): Unit = {
  val name = cartita.description
  name match
    case "refuerzo_moral" =>
      if p == this.Player1 then for (card <- this.board.p1m.data) {
        card.setPower(card.getPower + 1)
      }
      else if p == this.Player2 then for (card <- this.board.p1m.data) {
        card.setPower(card.getPower + 1)
      }


    case "vinculo_estrecho" =>
      if (p == this.Player1) {
        for (card <- board.p1m.data) {
          if (card.getName == cartita.getName) {
            card.setPower(card.getPower * 2)
          }
        }
      } else if (p == this.Player2) {
        for (card <- board.p1m.data) {
          if (card.getName == cartita.getName) {
            card.setPower(card.getPower * 2)
          }
        }
      }
    case _ =>
}

/** SiegeCombatCardEffect
 * function that applies the effect of a siege combat card
 * there are 3 possible effects:
 * refuerzo_moral: adds 1 power to all other cards in the same row
 * vinculo_estrecho: duplicates the power of any card in the same row with the same name
 * vainilla: no effect
 */
def SiegeCombatCardEffect(cartita: Card, p: Player): Unit = {
  val name = cartita.description
  name match
    case "refuerzo_moral" =>
      if p == this.Player1 then for (card <- this.board.p1s.data) {
        card.setPower(card.getPower + 1)
      }
      else if p == this.Player2 then for (card <- this.board.p1s.data) {
        card.setPower(card.getPower + 1)
      }


    case "vinculo_estrecho" =>
      if (p == this.Player1) {
        for (card <- board.p1s.data) {
          if (card.getName == cartita.getName) {
            card.setPower(card.getPower * 2)
          }
        }
      } else if (p == this.Player2) {
        for (card <- board.p1s.data) {
          if (card.getName == cartita.getName) {
            card.setPower(card.getPower * 2)
          }
        }
      }


    case _ =>
}

/** WeatherEffect
 * WeatherEffect is a function that applies the effect of a weather card
 * there are 5 possible effects:
 * "Escarcha mordiente", "Convierte el valor de fuerza de todas las cartas de melee a 1"
 * "Niebla Impenetrable", "Convierte el valor de fuerza de todas las cartas de rango a 1."
 * "LLuvia Torrencial", "Convierte el valor de fuerza de todas las cartas de asedio a 1."
 * "Despejar", "Limpia todos los efectos de clima del campo de batalla."
 * "Cuerno del Comandante", "Dobla la fuerza de todas las unidades de una fila propia al azar."
 *
 * because every card has a different effect, we will use name as id instead of description
 */
def WeatherEffect(n: String, p: Player): Unit = {
  n match
    case "Escarcha mordiente" =>
      for (card <- this.board.p1m.data) {
        card.setPower(1)
      }
      for (card <- this.board.p2m.data) {
        card.setPower(1)
      }

    case "Niebla Impenetrable" =>
      for (card <- this.board.p1r.data) {
        card.setPower(1)
      }
      for (card <- this.board.p2r.data) {
        card.setPower(1)
      }

    case "LLuvia Torrencial" =>
      for (card <- this.board.p1s.data) {
        card.setPower(1)
      }
      for (card <- this.board.p2s.data) {
        card.setPower(1)
      }
    case "Despejar" =>
      for (card <- this.board.p1m.data) {
        card.setPower(card.getOGPower)
      }
      for (card <- this.board.p1r.data) {
        card.setPower(card.getOGPower)
      }
      for (card <- this.board.p1s.data) {
        card.setPower(card.getOGPower)
      }
      for (card <- this.board.p2m.data) {
        card.setPower(card.getOGPower)
      }
      for (card <- this.board.p2r.data) {
        card.setPower(card.getOGPower)
      }
      for (card <- this.board.p2s.data) {
        card.setPower(card.getOGPower)
      }

}

*/
