package filter

class SubsetSum {

  import scala.collection.mutable.ListBuffer
  private def readInts(string: String) = {
    val strings1 = string.split(" ")
    val ints1 = new ListBuffer[Int]()
    for (string <- strings1)
      ints1.append(string.toInt)
    ints1.toList
  }

  def subsetSum(number: List[Int], against: Int): Int = {
    val numbers = number.sorted
    if (numbers.sum < against) return -1
    if (numbers.max >= against) return 1
    var itemSum: Int = 0
    var itemsCount: Int = 0
    for (i <- numbers.length - 1 to 0 by -1) {
      itemSum += numbers(i)
      itemsCount += 1
      if (itemSum >= against) return itemsCount
    }
    -1
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val numbersBuffer: ListBuffer[Int] = new ListBuffer[Int]
    for (i <- 1 to n)
      numbersBuffer.append(stdin.readInt)
    val numbers = numbersBuffer.toList
    val tests = stdin.readLine.trim.toInt
    for (i <- 1 to tests)
      println(subsetSum(numbers, stdin.readInt))
  }

}
