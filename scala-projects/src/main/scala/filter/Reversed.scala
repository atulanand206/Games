package filter


class Reversed {
  def f(arr: List[Int]): List[Int] = {
    import scala.collection.mutable.ListBuffer
    val list = ListBuffer[Int]()
    for (i <- arr.length - 1 to 0 by -1)
      list.append(arr(i))
    list.toList
  }
}
