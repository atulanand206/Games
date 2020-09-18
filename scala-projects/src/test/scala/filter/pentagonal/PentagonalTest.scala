package filter.pentagonal

import filter.pentagonal.Solution.Pentagonal
import org.scalatest.WordSpec

class PentagonalTest extends WordSpec {

  var pentagonal:Pentagonal = _
  "pentagonal numbers" in {
    pentagonal = new Pentagonal()
    pentagonal.generateNumbersForComparison(100000)
    assertPentagonalAtIndex(0, 0)
    assertPentagonalAtIndex(1, 1)
    assertPentagonalAtIndex(2, 5)
    assertPentagonalAtIndex(3, 12)
    assertPentagonalAtIndex(4, 22)
    assertPentagonalAtIndex(5, 35)
    assertPentagonalAtIndex(100000, 14999950000L)
  }

  private def assertPentagonalAtIndex(index: Int, value: Long): Unit = {
    println(index, value, pentagonal.getPentagonalAtIndex(index))
    assert(pentagonal.getPentagonalAtIndex(index) equals value)
  }
}
