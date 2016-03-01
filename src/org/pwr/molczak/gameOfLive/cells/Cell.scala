package org.pwr.molczak.gameOfLive.cells

import _root_.org.pwr.molczak.gameOfLive.cells.CellState._

case class Cell(initState: CellState) {

  var state: CellState = initState
  
  var zombieCounter = 0

  def kill = state = DEAD
  def brickBackTOLife = state = ALIVE
  
}