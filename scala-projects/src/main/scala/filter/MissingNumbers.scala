package filter


class MissingNumbers {

  import scala.collection.mutable.ListBuffer

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n1 = stdin.readLine.trim.toInt
    val string1 = stdin.readLine.trim
    val n2 = stdin.readLine.trim.toInt
    val string2 = stdin.readLine.trim

    println(missing(string1, string2))
  }

  def missing(stringA: String, stringB: String): String = {
    val ints1: List[Int] = readInts(stringA)
    val ints2: List[Int] = readInts(stringB)
    missing(ints1, ints2)
  }

  def missing(listA: List[Int], listB: List[Int]): String =
    toString(removeDuplicates(listB.diff(listA).sorted))

  private def toString(strings: List[Int]) = {
    val result = new StringBuilder
    for (items <- strings)
      result.append(items + " ")
    result.toString()
  }

  private def removeDuplicates(list: List[Int]): List[Int] = {
    val charSequence = new ListBuffer[Int]
    for (i <- list)
      if (!charSequence.contains(i))
        charSequence.append(i)
    charSequence.toList
  }

  private def readInts(string: String) = {
    val strings1 = string.split(" ")
    val ints1 = new ListBuffer[Int]()
    for (string <- strings1)
      ints1.append(string.toInt)
    ints1.toList
  }
}
