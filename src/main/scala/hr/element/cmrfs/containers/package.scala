package hr.element.cmrfs

package object containers {
  type GridPanel = scala.swing.GridPanel
  type BorderPanel = scala.swing.BorderPanel
  type Button = scala.swing.Button
  type TextField = scala.swing.TextField
  type ImageIcon = javax.swing.ImageIcon
  val BorderPanel = scala.swing.BorderPanel
  type ScrollPane = scala.swing.ScrollPane

  type EmptyBorder = javax.swing.border.EmptyBorder
  type BevelBorder = javax.swing.border.BevelBorder

  type ListView[T] = scala.swing.ListView[T]
  type Dimension = scala.swing.Dimension

  object Color {
    val blue = java.awt.Color.blue
  }

  val ButtonClicked = scala.swing.event.ButtonClicked
  val Key = scala.swing.event.Key
  val KeyPressed = scala.swing.event.KeyPressed
}
