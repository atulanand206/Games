package filter

class RotateStrings {

  private def toString(strings: List[String]) = {
    val result = new StringBuilder
    for (items <- strings)
      result.append(items + " ")
    result.toString()
  }

  private def nextRotatedString(name: String, i: Int): String = {
    var result = new StringBuilder
    for (j <- i to name.length)
      result.append(name.charAt(j - 1))
    for (j <- 1 until i)
      result.append(name.charAt(j - 1))
    result.toString()
  }

  import scala.collection.mutable.ListBuffer

  def rotatedStrings(name: String): String = {
    var strings = new ListBuffer[String]
    for (i <- 1 to name.length)
      strings.append(nextRotatedString(name, i + 1))
    toString(strings.toList)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt

    for (nItr <- 1 to n) {
      val x = stdin.readLine.trim
      println(rotatedStrings(x))
    }
  }
}
