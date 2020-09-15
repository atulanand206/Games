package filter

class OddSum {
  def f(arr: List[Int]): Int = {
    var sum = 0
    for (i <- arr if i % 2 != 0)
      sum += i
    sum
  }
}
