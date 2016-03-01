package org.pwr.molczak.gameOfLive.boards

import java.awt.{ Color, Graphics2D, Dimension }
import org.pwr.molczak.gameOfLive.drawing.MainPanel
import _root_.org.pwr.molczak.gameOfLive.cells.CellState._
import swing._
import java.awt.{ Graphics, Color }
import java.awt.event.{ ActionEvent, ActionListener }
import javax.swing.Timer
import org.pwr.molczak.gameOfLive.algorithms.Rules

object Runner extends SimpleSwingApplication {

  val path = "/home/booob/gameOfLifeData/oscylator2.csv"
  
  val rule = new Rules()
  
  val panel = new MainPanel(path) with ActionListener {
    preferredSize = new Dimension(300, 300)

    def actionPerformed(e: ActionEvent) {
//      rule.conwayRules(board)
//      rule.lifeWithoutDeth(board)
//      rule.maze(board)
//      rule.twoXtwo(board)
//      rule.replicator(board)
//      rule.ameba(board)
      rule.zombie(board)
      
      data = setColors(board)

      repaint
    }
  }

  def top = {
    new MainFrame {

      peer.setLocationRelativeTo(null)
      contents = panel
    }
  }
  
  val timer = new Timer(1500, panel)
  timer.start()

}