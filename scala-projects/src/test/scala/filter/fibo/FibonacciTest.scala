package filter.fibo

import filter.fibo.Solution.Fibonacci
import org.scalatest.{BeforeAndAfter, WordSpec};

class FibonacciTest extends WordSpec with BeforeAndAfter {

  var fib: Fibonacci = _
  before {
    fib = new Fibonacci()
    fib.generateFiboForComparison()
  }

  "fibonacci" in {
    assertFiboAtIndex(0, 0)
    assertFiboAtIndex(1, 1)
    assertFiboAtIndex(2, 1)
    assertFiboAtIndex(3, 2)
    assertFiboAtIndex(4, 3)
    assertFiboAtIndex(5, 5)
    assertFiboAtIndex(6, 8)
    assertFiboAtIndex(7, 13)
    assertFiboAtIndex(100, 24278230)
    assertFiboAtIndex(10000, 49520320)
  }

  // 1, 1, 2, 3,5,8,13
  // 0,1,1,2,3,5
  // 0,0,1,2,3,5
  "fibonacci 0" in assertFiboAtIndex(0, 0)
  "fibonacci 1" in assertFiboAtIndex(1, 1)
  "fibonacci 2" in assertFiboAtIndex(2, 1)
  "fibonacci 3" in assertFiboAtIndex(3, 2)
  "fibonacci 4" in assertFiboAtIndex(4, 3)
  "fibonacci 5" in assertFiboAtIndex(5, 5)
  "fibonacci 6" in assertFiboAtIndex(6, 8)
  "fibonacci 7" in assertFiboAtIndex(7, 13)
  "fibonacci 100" in assertFiboAtIndex(100, 24278230)
  "fibonacci 100000" in assertFiboAtIndex(10000, 49520320)


  private def assertFiboAtIndex(index: Int, value: Int): Unit = {
    println(index, value, fib.getFibonacciAtIndex(index))
    assert(fib.getFibonacciAtIndex(index) equals value)
  }
}
