package org.pwr.molczak.gameOfLive.utils

import org.pwr.molczak.gameOfLive.cells.CellState
import org.pwr.molczak.gameOfLive.cells.CellState._
import org.pwr.molczak.gameOfLive.cells.Cell

object DataUtils {

  def readData(path: String): Array[Array[Cell]] = {
    io.Source.fromFile(path)
      .getLines()
      .map(_.split(",").map(_.trim match {
        case "A" => new Cell(ALIVE)
        case "D" => new Cell(DEAD)
      }))
      .toArray
  }
}