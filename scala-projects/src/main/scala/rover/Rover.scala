package queen

import Direction._
import Heading._

class Rover(startingCoordinates: (Int, Int), startHeading: Char, startGrid: Grid = Grid(10, 10)) {

  private var position: Position = Position(startingCoordinates._1, startingCoordinates._2)
  private var heading: Heading = Heading(startHeading)
  private var grid: Grid = startGrid

  private val initialPosition = position.copy()
  private val initialHeading = heading.copy()
  private val initialGrid = grid.copy()

  def getCoordinates: Position = position

  def getHeading: Heading = heading

  def getGrid: Grid = grid

  def setHeading(head: Char): Unit = {
    if (isHeadingAllowed(head))
      heading = Heading(head)
  }

  def setNewGridSpecs(grd: Grid): Unit = {
    grid = grd.copy()
  }

  def reset(): Unit = {
    position = initialPosition.copy()
    heading = initialHeading.copy()
    grid = initialGrid.copy()
  }

  def executeCommands(commands: Array[Char]): Unit = {
    commands.foreach { cmd => executeCommand(cmd) }
  }

  private def executeCommand(cmd: Char): Unit = {
    if (isMovementAllowed(cmd))
      position = move(Direction(cmd))
    if (isTurningAllowed(cmd))
      heading = turn(Direction(cmd))
  }

  private def isHeadingAllowed(head: Char): Boolean = List('N', 'S', 'W', 'E') contains head

  private def isMovementAllowed(cmd: Char) = List('f', 'b') contains cmd

  private def isTurningAllowed(cmd: Char) = List('l', 'r') contains cmd

  private def move(direction: Direction) = direction match {
    case Forward => moveForward()
    case Backward => moveBackward()
  }

  private def moveBackward() = heading match {
    case North => decrementY()
    case South => incrementY()
    case West => incrementX()
    case East => decrementX()
  }

  private def moveForward() = heading match {
    case North => incrementY()
    case South => decrementY()
    case West => decrementX()
    case East => incrementX()
  }

  private def incrementX() = Position(nextX, position.y)

  private def decrementX() = Position(previousX, position.y)

  private def incrementY() = Position(position.x, nextY)

  private def decrementY() = Position(position.x, previousY)

  private def nextX = if (position.x == grid.width) 1 else position.x + 1

  private def previousX = if (position.x == 1) grid.width else position.x - 1

  private def nextY = if (position.y == grid.height + 1) grid.height else position.y + 1

  private def previousY = if (position.y == 1) 2 else position.y - 1

  private def turn(direction: Direction) = direction match {
    case Right => turnRight()
    case Left => turnLeft()
  }

  private def turnRight() = heading match {
    case North => East
    case South => West
    case West => North
    case East => South
  }

  private def turnLeft() = heading match {
    case North => West
    case South => East
    case West => South
    case East => North
  }
}

case class Heading(value: Char)

object Heading {
  val North: Heading = Heading('N')
  val South: Heading = Heading('S')
  val West: Heading = Heading('W')
  val East: Heading = Heading('E')
}

case class Direction(value: Char)

object Direction {
  val Forward: Direction = Direction('f')
  val Backward: Direction = Direction('b')
  val Right: Direction = Direction('r')
  val Left: Direction = Direction('l')
}

case class Position(x: Int, y: Int)

case class Grid(height: Int, width: Int)