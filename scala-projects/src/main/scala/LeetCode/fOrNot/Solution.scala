package LeetCode.fOrNot

object Solution {

  def main(args: Array[String]) {
    val t = io.StdIn.readInt()
    (1 to t).foreach { i =>
      val n = io.StdIn.readInt
      var nums: Map[String, String] = Map()
      (1 to n).map {x =>
        val s = io.StdIn.readLine.split(" ")
        nums+=(s(0)->s(1))
        x
      }
      if (nums.size == n) println("YES")
      else println("NO")
    }
  }
}
