package com.ferega.cmrfs

import scala.swing._
import scala.swing.event.MouseMoved

object MainApp extends SimpleSwingApplication {
  lazy val top = new MainFrame {
    minimumSize = new Dimension(200, 200)

    title = "CMRFS"
    contents = new containers.BaseContainer()
  }
}
