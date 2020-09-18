package filter

import filter.captainprime.Solution.{CaptainPrime, Fate}
import org.scalatest.{BeforeAndAfter, WordSpec}

import scala.collection.mutable.ListBuffer

class CaptainPrimeTest extends WordSpec with BeforeAndAfter {

  private var captainPrime: CaptainPrime = _

  before {
    captainPrime = new CaptainPrime()
  }

  "generate primes array" in {
    val actual = captainPrime.generatePrimesBooleanArrayFromNumbers(
      List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37))
    val expected = List(false,
      false, true, true, false, true, false, true, false, false, false,
      true, false, true, false, false, false, true, false, true, false,
      false, false, true, false, false, false, false, false, true, false,
      true, false, false, false, false, false, true)
    assert(expected.equals(actual))
  }

  "generate primes" in {
    var primes = captainPrime.generatePrimes(10)
    primes.equals(captainPrime.generatePrimesBooleanArrayFromNumbers(
      List(2, 3, 5, 7)
    ))

    primes = captainPrime.generatePrimes(30)
    primes.equals(captainPrime.generatePrimesBooleanArrayFromNumbers(
      List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    ))

    primes = captainPrime.generatePrimes(40)
    primes.equals(captainPrime.generatePrimesBooleanArrayFromNumbers(
      List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37)
    ))
  }

  "strip characters" in {
    assert(captainPrime.removeFromEnd(3135) equals 313)
    assert(captainPrime.removeFromBegin(3135) equals 135)
    assert(captainPrime.removeFromBegin(43454) equals 3454)
    assert(captainPrime.removeFromEnd(653) equals 65)
    assert(captainPrime.removeFromEnd(6) equals -1)
    assert(captainPrime.removeFromBegin(7) equals -1)
    assert(captainPrime.removeFromBegin(73) equals 3)
    assert(captainPrime.removeFromEnd(73) equals 7)
  }

  "contains zero" in {
    captainPrime.containsZero(1001) equals true
    captainPrime.containsZero(11) equals false
    captainPrime.containsZero(103201) equals true
    captainPrime.containsZero(42343) equals false
  }

  "parts of the ship" in {
    captainPrime.generatePrimesForComparison(100000)
    printAndAssertStripFromBegin(3137, true)
    printAndAssertStripFromBegin(1367, true)
    printAndAssertStripFromBegin(2333, false)
    printAndAssertStripFromBegin(12, false)
    printAndAssertStripFromBegin(101, false)
    printAndAssertStripFromEnd(3137, true)
    printAndAssertStripFromEnd(1367, false)
    printAndAssertStripFromEnd(2333, true)
    printAndAssertStripFromEnd(12, false)
    printAndAssertStripFromEnd(101, false)
    printAndAssertStripFromBegin(43, true)
    printAndAssertStripFromEnd(43, false)
    printAndAssertStripFromBegin(23, true)
    printAndAssertStripFromEnd(23, true)
    printAndAssertStripFromBegin(66, false)
    printAndAssertStripFromEnd(66, false)

  }

  "strip from end" in {
    captainPrime.generatePrimesForComparison(1000000)
    printAndAssertStripFromEnd(861613, false)
    printAndAssertStripFromBegin(861613, true)
    captainPrime.primes(861613) equals true
    captainPrime.primes(86161) equals false
  }

  private def printAndAssertStripFromBegin(value: Int, begin: Boolean) = {
    assert(captainPrime.stripFromBegin(value) equals begin)
  }

  private def printAndAssertStripFromEnd(value: Int, end: Boolean) = {
    assert(captainPrime.stripFromEnd(value) equals end)
  }

  "fate at index" in {
    captainPrime.generatePrimesForComparison(100000)
    assert(captainPrime.fate(38) equals Fate.Dead.value)
    printAndAssert(3137, Fate.Central)
    printAndAssert(1367, Fate.Left)
    printAndAssert(2333, Fate.Right)
    printAndAssert(101, Fate.Dead)
    printAndAssert(12, Fate.Dead)
    printAndAssert(43, Fate.Left)
    printAndAssert(23, Fate.Central)
    printAndAssert(66, Fate.Dead)
    printAndAssert(29, Fate.Right)
  }

  private def printAndAssert(value: Int, fate: Fate): Unit = {
    assert(captainPrime.fate(value) equals fate.value)
  }

  "failing test case" in {
    captainPrime.generatePrimesForComparison(1000000)
    val input = "37337\n73\n373393\n2393\n239933\n79\n599\n373\n31379\n71\n31379\n59393\n2399"
    val output = "RIGHT\nCENTRAL\nRIGHT\nRIGHT\nRIGHT\nRIGHT\nRIGHT\nCENTRAL\nRIGHT\nRIGHT\nRIGHT\nRIGHT\nRIGHT"
    val failInput = "337853\n"
    val failOutput = "LEFT\n"
    captainPrimeTestCase(input, output)
    println(captainPrime.primes(71))
    println(captainPrime.primes(7))
    println(captainPrime.primes(1))
    println(captainPrime.primes(861))
    println(captainPrime.primes(86))
    println(captainPrime.primes(8))
    captainPrimeTestCase("861613", "LEFT")

  }

  private def captainPrimeTestCase(inputStrings: String, resultsStrings: String): Unit = {
    val inputStringsArray = inputStrings.split("\n")
    val resultStringsArray = resultsStrings.split("\n")
    println(inputStringsArray.length)
    println(resultStringsArray.length)
    for (i <- 0 until inputStringsArray.length) {
      val input = inputStringsArray(i).toInt
      println(i, inputStringsArray(i).toInt, resultStringsArray(i), captainPrime.fate(input))
      assert(resultStringsArray(i) == captainPrime.fate(input))
    }
  }
}
