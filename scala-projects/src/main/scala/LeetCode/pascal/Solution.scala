package LeetCode.pascal

import scala.collection.mutable.ListBuffer

object Solution {

  def pascalRow(row: List[Int]): List[Int] = {
    row.head +: (1 until row.size).map(i => row(i-1) + row(i)).toList :+ row.head
  }

  def main(args: Array[String]) {
    val n = io.StdIn.readInt()
    val pascal: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
    pascal.append(List(1))
    pascal.append(List(1,1))
    (2 until n).foreach(_ => pascal.append(pascalRow(pascal.last)))
    pascal.foreach(row => {
      row.foreach(x => print(x + " "))
      println()
    })
  }
}
