package filter.pentagonal


object Solution {

  class Pentagonal {

    import scala.collection.mutable.ArrayBuffer

    var pentagonal: ArrayBuffer[Long] = new ArrayBuffer[Long]()

    def generateNumbersForComparison(limit: Int): Unit = {
      pentagonal.append(0)
      pentagonal.append(1)
      var additional = 4
      for (i <- 2 to limit) {
        pentagonal.append((pentagonal(i - 1) + additional))
        additional += 3
      }
    }

    def getPentagonalAtIndex(index: Int): Long = {
      pentagonal(index)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val pentagonal = new Pentagonal()
    pentagonal.generateNumbersForComparison(100000)
    for (_ <- 1 to n) {
      val x = stdin.readLine.trim.toInt
      println(pentagonal.getPentagonalAtIndex(x))
    }
  }
}
