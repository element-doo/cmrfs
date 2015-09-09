package com.ferega.cmrfs.containers

import scala.swing._

class MainContainer extends BorderPanel {
  val controlContainer = new ControlContainer
  val resultList = new ListView {
    preferredSize = new Dimension(0, 200)
    border = new javax.swing.border.BevelBorder(1)
  }
  
  layoutManager.setHgap(5)
  layoutManager.setVgap(5)
  layout(controlContainer) = BorderPanel.Position.North
  layout(resultList) = BorderPanel.Position.Center
}
