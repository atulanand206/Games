package filter

import scala.collection.mutable.ListBuffer

class RemoveDuplicates {

  def remove(name: String): String = {
    val res = new StringBuilder()
    val charSequence = new ListBuffer[Char]
    for (i <- name)
      if (!charSequence.contains(i))
        charSequence.append(i)
    for (i <- charSequence)
      res.append(i)
    res.toString()
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toString
    println(remove(n))
  }
}
