package filter.different

import java.util.Calendar

import filter.different.Solution.DifferentWays
import org.scalatest.{BeforeAndAfter, WordSpec}

class DifferentWaysTest extends WordSpec with BeforeAndAfter {

  var dif: DifferentWays = _

  before {
    dif = new DifferentWays()
  }

  "different ways" in {
    println(Calendar.getInstance().getTimeInMillis)
    dif.init(1001, 1001)
    println(Calendar.getInstance().getTimeInMillis)
    assertDiffAtIndex(2, 1, 2)
    assertDiffAtIndex(5, 1, 5)
    assertDiffAtIndex(5, 2, 10)
    assertDiffAtIndex(5, 3, 10)
    assertDiffAtIndex(10, 5, 252)
    println(Calendar.getInstance().getTimeInMillis)
  }

  private def assertDiffAtIndex(n: Int, k: Int, value: Int): Unit = {
    println(n, k, value, dif.determineCount(n, k))
    assert(dif.determineCount(n, k) equals value)
  }

}
