package com.ferega.cmrfs.core

import java.util.Properties
import java.io.{ File, FileInputStream }

object C {
  private val home = sys.props("user.dir")
  private val props = new Properties
  props.load(new FileInputStream(home + "\\cmrfs.config"))
  
  val BasePath = new File(props.getProperty("basePath"))
  val FileType = props.getProperty("fileType")
}