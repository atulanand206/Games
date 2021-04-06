package cardinal


object Cardinal {

  class Move(val value: Int)

  case object Plus extends Move(1)

  case object Zero extends Move(0)

  case object Minus extends Move(-1)

  def withinLimit(arr: Array[Int],
                  i: Int): Boolean =
    i >= 0 && i < arr.length

  def withinLimit(arr: Array[Array[Int]],
                  i: Int): Boolean =
    i >= 0 && i < arr.length

  def present(arr: Array[Array[Int]],
              i: Int, j: Int): Boolean =
    withinLimit(arr, i) &&
      withinLimit(arr(i), j) &&
      arr(i)(j) == 1

  def direction(arr: Array[Array[Int]],
                i: Int, j: Int,
                x: Move, y: Move): Boolean =
    (x, y) match {
      case (Plus, Plus) => present(arr, i + 1, j + 1)
      case (Plus, Zero) => present(arr, i + 1, j)
      case (Plus, Minus) => present(arr, i + 1, j - 1)
      case (Zero, Minus) => present(arr, i, j - 1)
      case (Zero, Plus) => present(arr, i, j + 1)
      case (Minus, Plus) => present(arr, i - 1, j + 1)
      case (Minus, Zero) => present(arr, i - 1, j)
      case (Minus, Minus) => present(arr, i - 1, j - 1)
      case (_, _) => false
    }

  def neighbours(arr: Array[Array[Int]],
                 i: Int, j: Int): Int = {
    (if (direction(arr, i, j, Minus, Minus)) 1 else 0) +
      (if (direction(arr, i, j, Minus, Zero)) 1 else 0) +
      (if (direction(arr, i, j, Minus, Plus)) 1 else 0) +
      (if (direction(arr, i, j, Zero, Minus)) 1 else 0) +
      (if (direction(arr, i, j, Zero, Plus)) 1 else 0) +
      (if (direction(arr, i, j, Plus, Minus)) 1 else 0) +
      (if (direction(arr, i, j, Plus, Zero)) 1 else 0) +
      (if (direction(arr, i, j, Plus, Plus)) 1 else 0)
  }

}

object CardinalTest extends App {


  val arr = Array(
    Array(0, 0, 0, 0, 0, 0),
    Array(0, 0, 0, 0, 0, 0),
    Array(0, 0, 1, 1, 1, 0),
    Array(0, 0, 1, 1, 1, 0),
    Array(0, 0, 1, 1, 1, 0),
    Array(0, 0, 0, 0, 0, 0))

  import Cardinal._

  println(Cardinal.direction(arr, 2, 2, Plus, Plus)) // true
  println(Cardinal.direction(arr, 2, 2, Plus, Minus)) // false
  println(Cardinal.direction(arr, 2, 2, Zero, Minus)) // false
  println(Cardinal.direction(arr, 2, 2, Plus, Zero)) // true
  println(Cardinal.direction(arr, 2, 2, Minus, Zero)) // false
  println(Cardinal.neighbours(arr, 2, 2)) // 3
  println(Cardinal.neighbours(arr, 3, 3)) // 8
  println(Cardinal.neighbours(arr, 4, 2)) // 3
  println(Cardinal.neighbours(arr, 2, 0)) // 0

}
