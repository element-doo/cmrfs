package hr.element.cmrfs

import java.awt.Toolkit
import javax.swing._

import containers._
import core._

import scala.swing._
import scala.util.Try

object MainApp extends SimpleSwingApplication {
  Toolkit.getDefaultToolkit().setDynamicLayout(true)
  System.setProperty("sun.awt.noerasebackground", "true")
  JFrame.setDefaultLookAndFeelDecorated(true)
  JDialog.setDefaultLookAndFeelDecorated(true)

  val searcher = new Searcher(C.BasePath, C.FileType)
  def search(): Unit = {
    val query = ControlContainer.searchQuery.text
    if (query.trim.isEmpty) {
      JOptionPane.showMessageDialog(null, "Prazan regex!", "Prazan regex!", JOptionPane.WARNING_MESSAGE)
    } else if (Try { query.r }.isFailure) {
      JOptionPane.showMessageDialog(null, query, "Neispravni regex!", JOptionPane.ERROR_MESSAGE)
    } else {
      val tipe = ControlContainer.searchType.current
      val pattern = s"(?i)\\\\${tipe}\\d(Html|Ansi|Auxi|Java|Text)\\{.*${query}.*\\}"

      val results = searcher.search(pattern)
      MainContainer.resultList.listData = results.toList
    }
  }

  lazy val top = new MainFrame {
    minimumSize = new Dimension(640, 640)
    title = "CMRFS"
    contents = new BaseContainer()
    iconImage = ControlContainer.searchIcon.getImage
  }

  ControlContainer.searchButton.reactions += {
    case ButtonClicked(_) => search()
  }

  new Thread(new Runnable {
    override def run(): Unit = {
      Thread.sleep(100000)
      sys.exit(0)
    }
  }).start();
}
