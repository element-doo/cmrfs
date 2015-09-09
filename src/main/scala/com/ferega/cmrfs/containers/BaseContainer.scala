package com.ferega.cmrfs.containers

import scala.swing._
import javax.swing.border.EmptyBorder

class BaseContainer extends GridPanel(1, 1) {
  val mainContainer = new MainContainer
  
  border = new EmptyBorder(5, 5, 5, 5)
  contents += mainContainer 
}
