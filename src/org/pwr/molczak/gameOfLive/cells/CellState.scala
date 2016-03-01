package org.pwr.molczak.gameOfLive.cells

object CellState extends Enumeration {
  type CellState = Value
  
  val ALIVE, DEAD, ZOMBIE = Value
}