
package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import java.util.Objects

class ClimateZone(var data: List[WeatherCard]) extends Zone {
 /** constructor for empty zone */
 def this() = this(List())
 
 /** 
  *  override for hashcode
  */
 override def hashCode(): Int = {
  var result = 0
  for (card <- data) {
   result += Objects.hash(card)
  }
  result
 }
 
 /** canEqual definition */
 def canEqual(other: Any): Boolean = other.isInstanceOf[ClimateZone]
 
 /** 
  *  override for equals
  */
  override def equals(other: Any): Boolean = {
   other match {
    case other: ClimateZone => {
     other.canEqual(this) &&
       this.hashCode() == other.hashCode()
    }
    case _ => false
    }
  }
 /**
  * add a card to the zone
  * this replaces the card if it is already in the zone
  */
 def add(card: WeatherCard): Unit = {
  data = List(card)
 }
}
