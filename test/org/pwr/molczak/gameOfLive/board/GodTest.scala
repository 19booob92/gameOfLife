package org.pwr.molczak.gameOfLive.board

import _root_.org.junit.Test
import _root_.org.pwr.molczak.gameOfLive.boards.Board
import _root_.org.junit.Assert._
import _root_.org.pwr.molczak.gameOfLive.cells.Cell
import _root_.org.pwr.molczak.gameOfLive.cells.CellState._
import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import org.pwr.molczak.gameOfLive.algorithms.Rules
import org.pwr.molczak.gameOfLive.algorithms.Rules
import org.scalatest.mock.MockitoSugar

class GodTest extends FunSuite with ShouldMatchers with BeforeAndAfter {

  test("Should set new bord with changed 2 cells (after two iterations)") {
    
    val data: Array[Array[Cell]] = Array(
        Array(new Cell(ALIVE), new Cell(DEAD), new Cell(ALIVE)),
        Array(new Cell(ALIVE), new Cell(DEAD), new Cell(ALIVE)),
        Array(new Cell(ALIVE), new Cell(DEAD), new Cell(ALIVE)))
    
    val board = new Board(3, data)
    val god = new Rules()


    board.data(0)(0) should equal (new Cell(ALIVE))
    
    god.conwayRules(board)
    
    board.data(0)(0) should equal (new Cell(DEAD))
  }

}