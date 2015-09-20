package hr.element.cmrfs
package core

case class FileDesc(path: Path, body: String)

private object Searcher
    extends StrictLogging {

  def listFiles(fileType: String, root: Path): IndexedSeq[Path] = {
    logger.trace(s"Listing directory: ${root.path} ...")
    val files = (root ** ("*." + fileType)).toIndexedSeq
    logger.debug {
      val nf = NumberFormat.getIntegerInstance
      val size = nf.format(files.flatMap(_.size).sum)
      val count = nf.format(files.size.toLong)
      s"Found ${size} bytes in ${count} files!"
    }
    files
  }

  def readFiles(paths: IndexedSeq[Path]): IndexedSeq[FileDesc] = {
    logger.trace(s"Reading files ...")
    val descs = paths flatMap readFile
    logger.debug(s"Done reading files!")
    descs
  }

  def readFile(path: Path): Option[FileDesc] = {
    val body = path.string(Codec.ISO8859)
    logger.trace(s"Reading file: ${path.path} ...")
    val start = body.indexOf(C.DatabaseEnd)
    if (start != -1) {
      Some(FileDesc(path, body.substring(start + C.DatabaseEnd.length)))
    } else {
      None
    }
  }
}

class Searcher(basePath: Path, fileType: String)
    extends StrictLogging {
  import Searcher._

  private val paths = listFiles(fileType, basePath)
  private val descs = readFiles(paths)

  def search(query: String): IndexedSeq[String] = {
    val pattern = query.r.pattern
    val hits = new VectorBuilder[String]
    var count = 0

    logger.debug(s"Starting search for ${pattern} ...")
    descs foreach { desc =>
      logger.trace(s"Searching through ${desc.path.path} ...")
      if (pattern.matcher(desc.body).find()) {
        count += 1

        val lines = desc.body.split("\n").toIndexedSeq
        var index = 0
        while (index < lines.length) {
          if (pattern.matcher(lines(index)).find()) {
            hits += desc.path.name
            var link = false
            while (!link && index < lines.length) {
              val candidate = lines(index)
              hits += "  " + candidate
              index += 1
              if (candidate.contains("Link")) {
                link = true
              }
            }
          } else {
            index += 1
          }
        }
      }
    }

    logger.debug(s"Search finished, found ${count} hits!")
    hits.result
  }
}
