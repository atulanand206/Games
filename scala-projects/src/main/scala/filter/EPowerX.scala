package filter

class EPowerX {
  def f(value: Double): Double = {
    var d = 1.0
    var iFactorial = 1
    for (i <- 1 to 9) {
      iFactorial *= i
      d += (Math.pow(value, i) / iFactorial)
    }
    trunc(d, 3)
  }

  def trunc(x: Double, n: Int): Double = {
    def p10(n: Int, pow: Long = 10): Long = if (n == 0) pow else p10(n - 1, pow * 10)

    if (n < 0) {
      val m = p10(-n).toDouble
      math.round(x / m) * m
    }
    else {
      val m = p10(n).toDouble
      math.round(x * m) / m
    }
  }

}
