package filter

import scala.collection.mutable.ListBuffer

class FilterArray {
  def f(delim: Int, arr: List[Int]): List[Int] = {
    var list = ListBuffer[Int]()
    for (item <- arr)
      if (item < delim)
        list += item
    list.toList
  }



}