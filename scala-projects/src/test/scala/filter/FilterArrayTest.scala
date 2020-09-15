package filter

import org.scalatest.WordSpec

import scala.collection.mutable.ListBuffer

class FilterArrayTest extends WordSpec {

  "array filtering" in {
    assert(new FilterArray().f(3, List(10, 9, 8, 2, 7, 5, 1, 3, 0)) == List(2, 1, 0))
  }

  "list replication" in {
    assert(new Replication().f(3, List(1, 2, 3, 4)) == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4))
  }

  "remove elements at odd positions" in {
    assert(new FilterPositions().f(List(2, 5, 3, 4, 6, 7, 9, 8)) == List(5, 4, 7, 8))
  }

  "generate array of size n" in {
    assert(new ArrayN().f(4) == List(1, 1, 1, 1))
  }

  "reverse array without stock method" in {
    assert(new Reversed().f(List(19, 22, 3, 28, 26, 17, 18, 4, 28, 0)) == List(0, 28, 4, 18, 17, 26, 28, 3, 22, 19))
  }

  "sum of odd elements" in {
    assert(new OddSum().f(List(3, 2, 4, 6, 5, 7, 8, 0, 1)) == 16)
  }

  "count items without library methods" in {
    assert(new CountItems().f(List(2, 5, 1, 4, 3, 7, 8, 6, 0, 9)) == 10)
  }

  "absolute values in the list" in {
    assert(new Absolute().f(List(2, -4, 3, -1, 23, -4, -54)) == List(2, 4, 3, 1, 23, 4, 54))
  }

  "checking exponential x" in {
    val ePowerX = new EPowerX()
    assert(ePowerX.f(20) == 2423600.1887)
    assert(ePowerX.f(5) == 143.6895)
    assert(ePowerX.f(0.5) == 1.6487)
    assert(ePowerX.f(-0.5) == 0.6065)
  }

  "rotate strings" in {
    assert(new RotateStrings().rotatedStrings("abcde") == "bcdea cdeab deabc eabcd abcde ")
  }

  "remove duplicates" in {
    assert(new RemoveDuplicates().remove("ccbabacc") == "cba")
  }

  "missing numbers" in {
    assert(new MissingNumbers().missing(List(203, 204, 205, 206, 207, 208, 203, 204, 205, 206), List(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204)) == "204 205 206 ")
  }

  "common divisors" in {
    assert(new Divisors().divisors(10, 4) == 2)
    assert(new Divisors().divisors("10 4") == 2)
    assert(new Divisors().divisors("1 100") == 1)
    assert(new Divisors().divisors("288 240") == 10)
  }

}
