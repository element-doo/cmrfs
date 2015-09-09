package com.ferega.cmrfs.containers

import scala.swing._
import javax.swing.border.BevelBorder

object ControlContainer {
  val searchIcon = this.getClass.getResource("/q16.png")
}

class ControlContainer extends BorderPanel {
  import ControlContainer._
  
  val queryField = new TextField {
    preferredSize = new Dimension(200, 25)
    border = new BevelBorder(1)
  }
  val searchButton = new Button() {
    preferredSize = new Dimension(25, 25)
    icon = new javax.swing.ImageIcon(searchIcon)
  }
  
  layoutManager.setHgap(5)
  layoutManager.setVgap(5)
  layout(queryField) = BorderPanel.Position.Center
  layout(searchButton) = BorderPanel.Position.East
}
