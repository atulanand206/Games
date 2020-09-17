package filter.captainprime



object Solution {

  class CaptainPrime() {

    var primes: List[Boolean] = _

    def generatePrimesForComparison(limit: Int): Unit = {
      primes = generatePrimes(limit)
    }

    import scala.collection.mutable.{ArrayBuffer, ListBuffer}

    def generatePrimes(limit: Int): List[Boolean] = {
      val primesArray: ArrayBuffer[Boolean] = initializePrimeBooleanBuffer(limit)
      determinePrimesForArray(limit, primesArray)
      primesArray.toList
    }

    private def initializePrimeBooleanBuffer(limit: Int) = {
      val primesArray = new ArrayBuffer[Boolean]()
      primesArray.append(false)
      for (_ <- 1 to limit)
        primesArray.append(true)
      primesArray
    }

    private def determinePrimesForArray(limit: BigInt, primesArray: ArrayBuffer[Boolean]): Unit = {
      import scala.math.BigInt.int2bigInt
      for (p:BigInt <- 2 to limit if p * p <= limit)
        if (primesArray(p.intValue))
          for (i <- p * p to limit by p if i <= limit && p * p > 0)
            primesArray(i.intValue) = false
    }

    def generatePrimesBooleanArrayFromNumbers(numbers: List[Int]): List[Boolean] = {
      val primesArray: ListBuffer[Boolean] = initializePrimeListBuffer(numbers)
      populatePrimesArray(numbers, primesArray)
      primesArray.toList
    }

    private def initializePrimeListBuffer(numbers: List[Int]) = {
      val primesArray = new ListBuffer[Boolean]
      primesArray.append(false)
      for (_ <- 1 to numbers.max)
        primesArray.append(false)
      primesArray
    }

    private def populatePrimesArray(numbers: List[Int], primesArray: ListBuffer[Boolean]): Unit = {
      for (i <- numbers)
        primesArray(i) = true
    }

    def removeFromBegin(x: Int): Int = {
      val string = x.toString
      if (string.length == 1)
        return -1
      string.substring(1).toInt
    }

    def removeFromEnd(x: Int): Int = {
      val string = x.toString
      if (string.length == 1)
        return -1
      string.substring(0, string.length - 1).toInt
    }

    def containsZero(x: Int): Boolean = {
      x.toString.contains("0")
    }

    def stripFromBegin(x: Int): Boolean = {
      if (containsZero(x))
        return false
      var begin = x
      while (begin != -1) {
        if (!primes(begin))
          return false
        begin = removeFromBegin(begin)
      }
      true
    }

    def stripFromEnd(x: Int): Boolean = {
      if (containsZero(x))
        return false
      var end = x
      while (end != -1) {
        if (!primes(end))
          return false
        end = removeFromEnd(end)
      }
      true
    }

    def isCentral(x: Int): Boolean = {
      stripFromBegin(x) && stripFromEnd(x)
    }

    def isLeft(x: Int): Boolean = {
      stripFromBegin(x) && !primes(removeFromEnd(x))
    }

    def isRight(x: Int): Boolean = {
      stripFromEnd(x) && !primes(removeFromBegin(x))
    }

    def fates(x: Int): Fate = {
      import Fate._
      if (containsZero(x) || !primes(x))
        return Dead
      if (isCentral(x))
        return Central
      if (isLeft(x))
        return Left
      if (isRight(x))
        return Right
      Dead
    }

    def fate(x: Int): String = {
      fates(x).value
    }
  }

  case class Fate(value: String)

  object Fate {
    var Central: Fate = Fate("CENTRAL")
    var Left: Fate = Fate("LEFT")
    var Right: Fate = Fate("RIGHT")
    var Dead: Fate = Fate("DEAD")
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val captainPrime = new CaptainPrime()
    captainPrime.generatePrimesForComparison(1000000)
    for (_ <- 1 to n) {
      val x = stdin.readLine.trim.toInt
      println(captainPrime.fate(x))
    }
  }
}
