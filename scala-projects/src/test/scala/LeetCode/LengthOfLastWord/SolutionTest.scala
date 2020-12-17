package LeetCode.LengthOfLastWord

import org.scalatest.WordSpec

class SolutionTest extends WordSpec {

  "length of last word" in {
    val solution = new Solution()
    assert (solution.lengthOfLastWord("Hello World") equals 5)
    assert (solution.lengthOfLastWord(" ") equals 0)
  }

}
