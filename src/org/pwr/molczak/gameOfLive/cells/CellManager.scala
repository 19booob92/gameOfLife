package org.pwr.molczak.gameOfLive.cells

import _root_.org.pwr.molczak.gameOfLive.cells.Direction._

object CellManager {

  def getCellIndex(x: Int, y: Int, direction: Direction) = {
    direction match {

      case NW => (x - 1, y - 1)
      case N  => (x, y - 1)
      case NE => (x + 1, y - 1)

      case E  => (x + 1, y)

      case W  => (x - 1, y)

      case SW => (x - 1, y + 1)
      case S  => (x, y + 1)
      case SE => (x + 1, y + 1)
    }
  }

}