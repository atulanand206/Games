package filter


class Absolute {
  def f(arr: List[Int]): List[Int] = {
    import scala.collection.mutable.ListBuffer
    val list = ListBuffer[Int]()
    for (i <- arr)
      list.append(if (i < 0) -i else i)
    list.toList
  }
}
