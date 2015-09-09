package com.ferega.cmrfs

import scala.swing._
import scala.swing.event._

object MainApp extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "CMRFS"
    size = new Dimension(300, 80)
  }
}