
package cl.uchile.dcc
package gwent.board


import java.util.Objects

/**
 * This class represents the board of the game.
 * The board is composed of 7 zones, 3 for each player and 1 for the climate.
 * 
 */
class Board(var p1s: MarginalZone, var p1r: RangeZone, var p1m: MeleeZone, var clima: ClimateZone, var p2m: MeleeZone, var p2r: RangeZone, var p2s: MarginalZone) {

  /** constructor for an empty board */
  def this() = this(new MarginalZone(), new RangeZone(), new MeleeZone(), new ClimateZone(), new MeleeZone(), new RangeZone(), new MarginalZone())

}
