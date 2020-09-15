package filter

import scala.math

class Divisors {

  def divisors(mario: Int, luigi: Int): Int = {
    var res: Int = 0;
    for (i <- 1 to math.min(mario, luigi))
      if (mario % i == 0 && luigi % i == 0)
        res += 1
    res
  }

  def divisors(x: String): Int = {
    var y = x.split(" ")
    divisors(y(0).toInt,y(1).toInt)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    for (nItr <- 1 to n)
      println(divisors(stdin.readLine.trim))
  }

}
