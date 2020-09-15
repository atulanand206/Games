package filter

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readInt

class ArrayN {
  def f(num:Int) : List[Int] = {
    val list = ListBuffer[Int]()
    for (i <- 1 to num)
      list.append(1)
    list.toList
  }

}
