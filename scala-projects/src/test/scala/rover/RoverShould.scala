package queen

import org.scalatest.{BeforeAndAfter, WordSpec}
import Heading._

class RoverShould extends WordSpec with BeforeAndAfter {

  private var rover: Rover = _

  before {
    rover = new Rover((1, 1), 'N')
  }

  "initialize with starting point and heading" in {
    assert(rover.getCoordinates == Position(1, 1))
    assert(rover.getHeading == North)
  }

  "receive and execute commands - empty" in {
    rover.executeCommands(Array())
    assert(rover.getCoordinates == Position(1, 1))
    assert(rover.getHeading == North)
  }

  "move forward" in {
    rover.executeCommands(Array('f'))
    assert(rover.getCoordinates == Position(1, 2))
    assert(rover.getHeading == North)
  }

  "move forward multiple steps" in {
    rover.executeCommands(Array('f', 'f', 'f'))
    assert(rover.getCoordinates == Position(1, 4))
    assert(rover.getHeading == North)
  }

  "move three steps forward and one backwards" in {
    rover.executeCommands(Array('f', 'f', 'f', 'b'))
    assert(rover.getCoordinates == Position(1, 3))
    assert(rover.getHeading == North)
  }

  "move forward/backwards heading South" in {
    rover.reset()
    rover.setHeading('S')
    rover.executeCommands(Array('f', 'b', 'f'))
    assert(rover.getCoordinates == Position(1, 10))
    assert(rover.getHeading == South)
  }

  "move forward/backwards heading West" in {
    rover.reset()
    rover.setHeading('W')
    rover.executeCommands(Array('f', 'b', 'f'))
    assert(rover.getCoordinates == Position(10, 1))
    assert(rover.getHeading == West)
  }

  "move forward/backwards heading East" in {
    rover.reset()
    rover.setHeading('E')
    rover.executeCommands(Array('f', 'b', 'f'))
    assert(rover.getCoordinates == Position(2, 1))
    assert(rover.getHeading == East)
  }

  "change the heading direction towards West" in {
    assert(rover.getHeading == North)
    rover.setHeading('W')
    assert(rover.getHeading == West)
  }

  "reset rover's position and heading after changing state" in {
    rover.setHeading('W')
    assert(rover.getHeading == West)
    rover.executeCommands(Array('f', 'b', 'f', 'b', 'f'))
    assert(rover.getCoordinates == Position(10, 1))
    rover.reset()
    assert(rover.getCoordinates == Position(1, 1))
    assert(rover.getHeading == North)
  }

  "turn left to change heading" in {
    rover.executeCommands(Array('l'))
    assert(rover.getHeading == West)
    rover.executeCommands(Array('l'))
    assert(rover.getHeading == South)
    rover.executeCommands(Array('l'))
    assert(rover.getHeading == East)
    rover.executeCommands(Array('l'))
    assert(rover.getHeading == North)
  }

  "turn right to change heading" in {
    rover.executeCommands(Array('r'))
    assert(rover.getHeading == East)
    rover.executeCommands(Array('r'))
    assert(rover.getHeading == South)
    rover.executeCommands(Array('r'))
    assert(rover.getHeading == West)
    rover.executeCommands(Array('r'))
    assert(rover.getHeading == North)
  }

  "execute unknown commands" in {
    rover.executeCommands(Array('d', 'c', 'e'))
    assert(rover.getCoordinates == Position(1, 1))
    assert(rover.getHeading == North)
  }

  "set and update grid specs" in {
    assert(rover.getGrid == Grid(10, 10))
    rover.setNewGridSpecs(Grid(40, 40))
    assert(rover.getGrid == Grid(40, 40))
  }

  "execute a bunch of commands" in {
    rover.setNewGridSpecs(Grid(3, 3))
    rover.executeCommands(Array('f', 'f', 'f'))
    assert(rover.getCoordinates == Position(1, 4))
    assert(rover.getHeading == North)
  }

}
