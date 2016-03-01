package org.pwr.molczak.gameOfLive.boards

import _root_.org.pwr.molczak.gameOfLive.cells.CellState._
import _root_.org.pwr.molczak.gameOfLive.cells.Direction._
import _root_.org.pwr.molczak.gameOfLive.cells.Cell
import _root_.org.pwr.molczak.gameOfLive.cells.CellManager
import org.pwr.molczak.gameOfLive.cells.Direction
import org.pwr.molczak.gameOfLive.cells.CellState
import org.pwr.molczak.gameOfLive.utils.DataUtils

class Board(val size: Int, var data: Array[Array[Cell]]) {
  require(size > 0, "Szerokość planszy musi być większa od zera")

  def findAmountOfDethCells(x: Int, y: Int): Tuple2[Int, Int] = {
    var amountOfDeaths = 0
    var amountOfAlives = 0
    
    var result = (0, 0)

    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, N)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, NE)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, E)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, SE)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, S)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, SW)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, W)
    result = result + increaseProperCounter(CellManager.getCellIndex, x, y, NW)

    return result
  }

  def increaseProperCounter(getter: (Int, Int, Direction) => (Int, Int), x: Int, y: Int, dir: Direction): Tuple2[Int, Int] = {
    val idx = getter(x, y, dir)

    findIncrementValues(idx)
  }

  def findIncrementValues(idx: (Int, Int)): Tuple2[Int, Int] = {
    if (!isOutOfBound(idx) && data(idx._1)(idx._2).state == DEAD)
      return (0, 1)
    else if (!isOutOfBound(idx) && data(idx._1)(idx._2).state == ALIVE)
      return (1, 0)
    else
      return (0, 0)
  }

  def isOutOfBound(idx: (Int, Int)) = {
    if (idx._1 < 0 || idx._2 < 0 || idx._1 >= size || idx._2 >= size)
      true
    else
      false
  }

  implicit class TupleOperations[A: Numeric, B: Numeric](t: (A, B)) {
    import Numeric.Implicits._

    def +(p: (A, B)) = (p._1 + t._1, p._2 + t._2)
  }

}