package filter.fibo

object Solution {

  class Fibonacci {

    import scala.collection.mutable.ListBuffer

    var fibonacci: ListBuffer[Int] = new ListBuffer[Int]()

    def generateFiboForComparison(): Unit = {
      fibonacci.append(0)
      fibonacci.append(1)
    }

    def getFibonacciAtIndex(index: Int): Int = {
      for (i <- fibonacci.size - 1 to index)
        fibonacci.append((fibonacci(i - 1) + fibonacci(i)) % (100000007))
      fibonacci(index)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val fibo = new Fibonacci()
    fibo.generateFiboForComparison()
    for (_ <- 1 to n) {
      val x = stdin.readLine.trim.toInt
      println(fibo.getFibonacciAtIndex(x))
    }
  }
}
