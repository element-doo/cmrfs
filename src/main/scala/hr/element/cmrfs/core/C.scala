package hr.element.cmrfs
package core

object C {
  private val props = {
    val props = new Properties
    val home = sys.props("user.home") + "/.config/cmrfs/cmrfs.config"
    Path(home.replace('\\', '/'), '/').inputStream acquireAndGet props.load
    props.asScala
  }

  val BasePath = Path(props("basePath").replace('\\', '/'), '/')
  val FileType = props("fileType")
  val DatabaseEnd = props("databaseEnd")
}
