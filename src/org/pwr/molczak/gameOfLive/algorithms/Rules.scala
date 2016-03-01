package org.pwr.molczak.gameOfLive.algorithms

import _root_.org.pwr.molczak.gameOfLive.cells.CellState._
import _root_.org.pwr.molczak.gameOfLive.cells.Cell
import org.pwr.molczak.gameOfLive.boards.Board

class Rules {

  def conwayRules(board: Board) = {
    val MIN_ALIVE_CELLS = 1
    val MAX_ALIVE_CELLS = 3

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (board.findAmountOfDethCells(x, y)._1 > MIN_ALIVE_CELLS &&
        board.findAmountOfDethCells(x, y)._1 <= MAX_ALIVE_CELLS) {

        if (board.findAmountOfDethCells(x, y)._1 == MAX_ALIVE_CELLS)
          newBoard(x)(y) = new Cell(ALIVE)
        else
          newBoard(x)(y) = board.data(x)(y)
      } else
        newBoard(x)(y) = new Cell(DEAD)
    }
    board.data = newBoard
  }

  def lifeWithoutDeth(board: Board) = {
    val BIRTH_VALUE = 3

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (board.findAmountOfDethCells(x, y)._1 == BIRTH_VALUE)
        newBoard(x)(y) = new Cell(ALIVE)
      else
        newBoard(x)(y) = board.data(x)(y)
    }
    board.data = newBoard
  }

  def maze(board: Board) = {
    val STILL_ALIVE_VALUES = Array(1, 2, 3, 4, 5)
    val BIRTH_VALUE = 3

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (STILL_ALIVE_VALUES contains board.findAmountOfDethCells(x, y)._1) {

        if (board.findAmountOfDethCells(x, y)._1 == BIRTH_VALUE)
          newBoard(x)(y) = new Cell(ALIVE)
        else
          newBoard(x)(y) = board.data(x)(y)
      } else
        newBoard(x)(y) = new Cell(DEAD)
    }
    board.data = newBoard
  }

  def twoXtwo(board: Board) = {
    val STILL_ALIVE_VALUES = Array(1, 2, 5)
    val BIRTH_VALUES = Array(3, 6)

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (STILL_ALIVE_VALUES contains board.findAmountOfDethCells(x, y)._1) {
        if (BIRTH_VALUES contains board.findAmountOfDethCells(x, y)._1)
          newBoard(x)(y) = new Cell(ALIVE)
        else
          newBoard(x)(y) = board.data(x)(y)
      } else
        newBoard(x)(y) = new Cell(DEAD)
    }
    board.data = newBoard
  }
  def replicator(board: Board) = {
    val STILL_ALIVE_VALUES = Array(1, 3, 5, 7)
    val BIRTH_VALUES = Array(1, 3, 5, 7)

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (STILL_ALIVE_VALUES contains board.findAmountOfDethCells(x, y)._1) {
        if (BIRTH_VALUES contains board.findAmountOfDethCells(x, y)._1)
          newBoard(x)(y) = new Cell(ALIVE)
        else
          newBoard(x)(y) = board.data(x)(y)
      } else
        newBoard(x)(y) = new Cell(DEAD)
    }
    board.data = newBoard
  }
  def ameba(board: Board) = {
    val STILL_ALIVE_VALUES = Array(1, 3, 5, 8)
    val BIRTH_VALUES = Array(3, 5, 7)

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (STILL_ALIVE_VALUES contains board.findAmountOfDethCells(x, y)._1) {
        if (BIRTH_VALUES contains board.findAmountOfDethCells(x, y)._1)
          newBoard(x)(y) = new Cell(ALIVE)
        else
          newBoard(x)(y) = board.data(x)(y)
      } else
        newBoard(x)(y) = new Cell(DEAD)
    }
    board.data = newBoard
  }

  def zombie(board: Board) = {
    val STILL_ALIVE_VALUES = Array(1, 3, 5, 8)
    val BIRTH_VALUES = Array(3, 5)

    val newBoard = Array.ofDim[Cell](board.size, board.size)

    for (x <- 0 to board.size - 1; y <- 0 to board.size - 1) {
      if (STILL_ALIVE_VALUES contains board.findAmountOfDethCells(x, y)._1) {
        if (BIRTH_VALUES contains board.findAmountOfDethCells(x, y)._1)
          newBoard(x)(y) = new Cell(ALIVE)
        else
          newBoard(x)(y) = board.data(x)(y)
      } else {
        val zombieCell = new Cell(DEAD)
        zombieCell.zombieCounter = board.data(x)(y).zombieCounter + 1
        if (zombieCell.zombieCounter > 10)
          newBoard(x)(y) = new Cell(ZOMBIE)
        else
          newBoard(x)(y) = zombieCell
      }
    }
    board.data = newBoard
  }

}