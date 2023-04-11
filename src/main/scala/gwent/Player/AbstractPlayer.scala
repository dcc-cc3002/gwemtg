package cl.uchile.dcc
package gwent.Player

/**
 * AbstractPlayer
 * esta clase es una abstracion de los actores que toman las decisiones en el TCG Gwent
 * a partir de ella se implementan los jugadores humanos Player y npcs ComputerPlayer
 *
 *
 * @author Hugo Diaz
 *
 * @since 1.0.0
 * @version 1.0.0
 */
private abstract class AbstractPlayer(val name: String, var deck: List[Card])
{

}

//este es el constructor de un jugador humano
class Player(name: String, deck: List[Card]) extends AbstractPlayer(name, deck)
{
  
}

//este es el constructor de un jugador automata
class ComputerPlayer(name: String, deck: List[Card]) extends AbstractPlayer(name, deck)
{
  
}