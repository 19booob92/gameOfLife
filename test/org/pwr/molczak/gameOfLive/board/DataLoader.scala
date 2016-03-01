package org.pwr.molczak.gameOfLive.board

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite
import org.pwr.molczak.gameOfLive.utils.DataUtils
import _root_.org.pwr.molczak.gameOfLive.cells.CellState._

class DataLoader extends FunSuite with ShouldMatchers {

  val PATH = "/home/booob/gameOfLifeData/1.csv"

  test("Should load file as array of enums)") {

    val result = DataUtils.readData(PATH)

    result(0)(0) should equal (ALIVE)
    result(0)(1) should equal (DEAD)
    result(0)(2) should equal (ALIVE)
    
    result(1)(0) should equal (ALIVE)
    result(1)(1) should equal (DEAD)
    result(1)(2) should equal (ALIVE)
  }

}