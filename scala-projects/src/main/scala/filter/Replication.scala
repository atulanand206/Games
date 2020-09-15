package filter

import scala.collection.mutable.ListBuffer

class Replication {
  def f(num: Int, arr: List[Int]): List[Int] = {
    var list = ListBuffer[Int]()
    for (item <- arr)
      for (_ <- 1 to num)
        list += item
    list.toList
  }
}