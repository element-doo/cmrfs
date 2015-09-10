package com.ferega.cmrfs.core

import java.io.File
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

case class FileDesc(file: File, body: String, lineStarts: Map[Int, Int])

object Searcher {
  private def listFiles(fileType: String, root: File): Array[File] = {
    val files = root.listFiles
    val filtered = files.filter(_.getName.endsWith("."+fileType))
    filtered ++ files.filter(_.isDirectory).flatMap(listFiles(fileType, _))
  }
  
  private def readFiles(files: Array[File]): Array[FileDesc] = files map readFile
  
  private def readFile(file: File): FileDesc = {
    val lines = Source.fromFile(file).getLines.toArray
    val indexedLines = lines.zipWithIndex
    
    var charCount = 0
    val lineStarts = indexedLines.map {
      case (line, index) =>
        val lineStart = charCount
        charCount += line.length + 1
        lineStart -> (index + 1)
    }
    
    FileDesc(file, lines.mkString("\n"), lineStarts.toMap)
  }
}


class Searcher(basePath: File, fileType: String) {
  import Searcher._
  
  private val files = listFiles(fileType, basePath)
  private val descs = readFiles(files)
  
  def search(query: String): Array[String] = {
    val pattern = (".*?" + query).r.pattern
    val result = new ArrayBuffer[String]
    
    descs.foreach { desc =>
      val matches = pattern.matcher(desc.body)
      while (matches.find()) {
        val r = desc.file + " :: " + desc.lineStarts(matches.start()) + ": " + matches.group(0)
        result += r
      }
    }
    
    return result.toArray
  }
}  
