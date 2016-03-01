package org.pwr.molczak.gameOfLive.drawing

import java.awt.Graphics2D
import java.awt.Color
import scala.swing.Panel
import org.pwr.molczak.gameOfLive.boards.Board
import _root_.org.pwr.molczak.gameOfLive.cells.CellState._
import org.pwr.molczak.gameOfLive.algorithms.Rules
import org.pwr.molczak.gameOfLive.utils.DataUtils

class MainPanel(path: String) extends Panel {

  val dataFromFile = DataUtils.readData(path)
  
  val SIZE = dataFromFile(0).length
  val board = new Board(SIZE, dataFromFile);

  var data = Array.ofDim[Color](SIZE, SIZE)

  override def paintComponent(g: Graphics2D) {

    data = setColors(board)

    val dx = g.getClipBounds.width.toFloat / data.length
    val dy = g.getClipBounds.height.toFloat / data.map(_.length).max

    for {
      x <- 0 until data.length
      y <- 0 until data(x).length
      x1 = (x * dx).toInt
      y1 = (y * dy).toInt
      x2 = ((x + 1) * dx).toInt
      y2 = ((y + 1) * dy).toInt
    } {
      data(x)(y) match {
        case c: Color => g.setColor(c)
        case _        => g.setColor(Color.WHITE)
      }
      g.fillRect(x1, y1, x2 - x1, y2 - y1)
    }
  }

  def setColors(board: Board): Array[Array[Color]] = {
    val colors = Array.ofDim[Color](SIZE, SIZE)

    for (x <- 0 to SIZE - 1; y <- 0 to SIZE - 1) {
      board.data(x)(y).state match {
        case ALIVE => colors(y)(x) = Color.YELLOW
        case DEAD => colors(y)(x) = Color.BLACK
        case ZOMBIE => colors(y)(x) = Color.GREEN
      }
    }

    return colors
  }

}