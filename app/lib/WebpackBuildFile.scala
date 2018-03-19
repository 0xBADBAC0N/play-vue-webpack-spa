package lib

import java.io.File

object WebpackBuildFile {
  private val prefix = new java.io.File(".").getCanonicalPath
  private val d = new File(prefix+"/public/bundle")

  val jsBundle: String = if(d.exists && d.isDirectory) {
    d.listFiles.filter(_.isFile).toList.find(f => f.getName.contains("js.bundle.")).get.getName.replace(".gz", "")
  } else ""

//  val cssBundle: String = if(d.exists && d.isDirectory) {
//    d.listFiles.filter(_.isFile).toList.find(f => f.getName.contains("style.bundle.")).get.getName.replace(".gz", "")
//  } else ""

}
