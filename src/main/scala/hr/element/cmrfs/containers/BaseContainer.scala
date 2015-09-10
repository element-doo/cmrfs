package hr.element.cmrfs
package containers

object BaseContainer {
  val mainContainer = new MainContainer
}

class BaseContainer extends GridPanel(1, 1) {
  import BaseContainer._

  border = new EmptyBorder(5, 5, 5, 5)
  contents += mainContainer
}
