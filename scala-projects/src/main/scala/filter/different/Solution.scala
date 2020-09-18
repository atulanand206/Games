package filter.different


object Solution {

  class DifferentWays {

    import scala.collection.mutable.ArrayBuffer

    var count: ArrayBuffer[ArrayBuffer[Int]] = _

    def fillArray(n: Int, k: Int): Unit = {
      count = new ArrayBuffer[ArrayBuffer[Int]]
      for (i <- 0 to n) {
        val buffer = new ArrayBuffer[Int]
        for (j <- 0 to k)
          buffer.append(if ((j == 0) || (i == j)) 1 else 0)
        count.append(buffer)
      }
      for (i <- 1 to n) {
        for (j <- 1 to k) {
          if (i == j)
            count(i)(j) = 1
          else
            count(i)(j) = (count(i - 1)(j - 1) + count(i - 1)(j)) % 100000007
        }
      }
    }

    def determineCount(n: Int, k: Int): Int = {
      count(n)(k)
    }

    def init(n: Int, k: Int): Unit = {
      fillArray(n, k)
    }

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val differentWays = new DifferentWays()
    differentWays.init(1001, 1001)
    for (_ <- 1 to n) {
      val strings = stdin.readLine.trim.split(" ")
      val n = strings(0).toInt
      val k = strings(1).toInt
      println(differentWays.determineCount(n, k))
    }
  }
}
