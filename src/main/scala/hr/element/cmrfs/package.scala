package hr.element

package object cmrfs
    extends scala.collection.convert.DecorateAsScala {

  type Properties = java.util.Properties

  val Path = scalax.file.Path
  type Path = scalax.file.Path
  val Codec = scalax.io.Codec

  val Resource = scalax.io.Resource

  type StrictLogging = com.typesafe.scalalogging.StrictLogging
  type VectorBuilder[T] = scala.collection.immutable.VectorBuilder[T]

  object NumberFormat {
    def getIntegerInstance = java.text.NumberFormat.getIntegerInstance
  }
}
