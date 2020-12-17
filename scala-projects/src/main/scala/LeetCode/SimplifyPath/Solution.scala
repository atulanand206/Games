package LeetCode.SimplifyPath

class Solution {

  def reduceDoubleDots(res: String): String = {
    import scala.collection.mutable.ArrayBuffer
    println("reduction")
    val strings = ArrayBuffer(res.split("/"): _*)
    strings.insert(0, "")
    strings.insert(strings.length, "")
    println(strings.length)
    while (strings.indexOf(".") != -1)
      strings.remove(strings.indexOf("."))
    while (strings.indexOf("..") != -1) {
      val i = strings.indexOf("..")
      println(i)
      if (i > 1) {
        strings.remove(i - 1)
        strings.remove(i - 1)
      } else if (i == 1) {
        strings.remove(i)
      }
    }
    if (strings.isEmpty)
      return "/"
    println("reduced")
    val ress = strings.mkString("/")
    ress
  }

  def simplifyPath(path: String): String = {
    var res = path
    println(res)

    res = reduceDoubleDots(res.replace("//", "/"))

    println(res)
    if (res.endsWith("/") && res.length > 1) res = res.substring(0, res.length - 1)
    println(res)
    res
  }

}
