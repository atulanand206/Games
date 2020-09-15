package filter

import scala.collection.mutable.ListBuffer

class FilterPositions {
  def f(arr: List[Int]): List[Int] = {
    var list = ListBuffer[Int]()
    for (i <- arr.indices if i % 2 != 0)
      list += arr(i)
    list.toList
  }
}