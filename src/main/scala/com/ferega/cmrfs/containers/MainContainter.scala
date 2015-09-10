package com.ferega.cmrfs.containers

import javax.swing.border.BevelBorder
import scala.swing._

object MainContainer {
  val controlContainer = new ControlContainer
  
  val resultList = new ListView[String] {
    preferredSize = new Dimension(0, 200)
    border = new BevelBorder(1)
  }
}

class MainContainer extends BorderPanel {
  import MainContainer._

  layoutManager.setHgap(5)
  layoutManager.setVgap(5)
  layout(controlContainer) = BorderPanel.Position.North
  layout(resultList) = BorderPanel.Position.Center
}
