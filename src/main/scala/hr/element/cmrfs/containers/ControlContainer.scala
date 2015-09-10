package hr.element.cmrfs
package containers

object ControlContainer {
  private val authorText = "Author"
  private val keywordText = "Keyword"

  private def html(text: String) =
    s"""<html><b color="red">${text.head}</b>${text.tail}</html>"""

  val searchIcon = new ImageIcon(getClass.getResource("/q16.png"))
  val searchType = new Button(html(authorText)) {
    var current = authorText
    focusable = false
    listenTo(this)
    reactions += {
      case ButtonClicked(_) =>
        current = if (current == authorText) keywordText else authorText
        text = html(current)
    }
  }

  val searchQuery = new TextField {
    preferredSize = new Dimension(200, 25)
    border = new BevelBorder(1)
    foreground = Color.blue
    listenTo(keys)
    reactions += {
      case KeyPressed(_, Key.Enter, _, _) =>
        searchButton.doClick()
    }
  }

  val searchButton = new Button() {
    preferredSize = new Dimension(25, 25)
    icon = searchIcon
  }
}

class ControlContainer extends BorderPanel {
  import ControlContainer._

  layoutManager.setHgap(5)
  layoutManager.setVgap(5)
  layout(searchType) = BorderPanel.Position.West
  layout(searchQuery) = BorderPanel.Position.Center
  layout(searchButton) = BorderPanel.Position.East
}
