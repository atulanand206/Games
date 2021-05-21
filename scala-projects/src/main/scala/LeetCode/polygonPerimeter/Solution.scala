package LeetCode.polygonPerimeter

object Solution {

  def main(args: Array[String]): Unit = {
    val t = io.StdIn.readInt()
    val l = (1 to t).map {
      _ =>
        io.StdIn.readLine.split(" ")
          .map(x => Integer.parseInt(x).toDouble).toSeq
    }
    val k:Double = dist(l(0), l(l.size-1)) +
      (1 until l.size).map(i => {
        dist(l(i), l(i - 1))
      }).sum
    println(k)
  }

  private def dist(l1: Seq[Double], l2: Seq[Double]):Double = {
    Math.sqrt(Math.pow(l1.head - l2.head, 2) + Math.pow(l1(1) - l2(1), 2))
  }
}
