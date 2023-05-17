package cl.uchile.dcc
package gwent.Side

import gwent.Carta.Carta

/**
 * Board
 * esta clase representa el lado correspondiente a un jugador del campo de battalla
 * es una tupla de tres listas de cartas
 * el primer elemento es la zona de mele
 * el segundo elemento es la zona de rango
 * el tercer elemento es la zona de asedio
 *
 * @author Hugo Diaz
 * @since 2.1.1
 * @version 2.1.1
 */

class Side(var mele: List[Carta], var rango: List[Carta], var asedio: List[Carta]){
  
}
