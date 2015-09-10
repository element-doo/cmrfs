package hr.element.cmrfs
package containers

import scala.swing.event.MouseClicked

object MainContainer {
  val controlContainer = new ControlContainer

  val resultList = new ListView[String] {
    border = new BevelBorder(1)

    listenTo(mouse.clicks)
    reactions += {
      case MouseClicked(source, _, _, clicks, _) if clicks > 1 =>
        println(source)
    }
  }
}

class MainContainer extends BorderPanel {
  import MainContainer._

  layoutManager.setHgap(5)
  layoutManager.setVgap(5)
  layout(controlContainer) = BorderPanel.Position.North
  layout(new ScrollPane(resultList)) = BorderPanel.Position.Center
}
