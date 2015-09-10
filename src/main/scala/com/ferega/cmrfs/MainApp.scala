package com.ferega.cmrfs

import core.{ C, Searcher }
import containers._

import scala.swing._
import scala.swing.event.ButtonClicked

object MainApp extends SimpleSwingApplication {
  val searcher = new Searcher(C.BasePath, C.FileType)

  def search() {
    val query = ControlContainer.queryField.text
    val results = searcher.search(query)
    MainContainer.resultList.listData = results.toList
  }

  lazy val top = new MainFrame {
    minimumSize = new Dimension(200, 200)

    title = "CMRFS"
    contents = new BaseContainer()
  }

  ControlContainer.searchButton.reactions += {
    case ButtonClicked(_) => search()
  }
}
