package cl.uchile.dcc
package gwent.Player

/**
 * AbstractPlayer
 * esta clase es una abstracion de los actores que toman las decisiones en el TCG Gwent
 * a partir de ella se implementan los jugadores humanos Player y npcs ComputerPlayer
 */
class AbstractPlayer
{

}
abstract class AbstractPlayer(val name: String, var deck: List[Card])

//esta es la implementacion de un jugador humano
class Player(name: String, deck: List[Card]) extends AbstractPlayer(name, deck)

//
class ComputerPlayer(name: String, deck: List[Card]) extends AbstractPlayer(name, deck)
