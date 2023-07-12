
package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import java.util.Objects

class ClimateZone(var data: List[WeatherCard]) extends AbstractZone(data: List[Any]){

 def this() = this(List())
}
