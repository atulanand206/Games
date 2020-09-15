package filter

class CountItems {
  def f(arr: List[Int]): Int = {
    var size = 0
    for (_ <- arr)
      size += 1
    size
  }
}
