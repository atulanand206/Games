package LeetCode.LengthOfLastWord

class Solution {

  def lengthOfLastWord(s: String): Int = {
    val strings = s.split(" ")
    if (strings.isEmpty) 0 else strings.last.length
  }

}
