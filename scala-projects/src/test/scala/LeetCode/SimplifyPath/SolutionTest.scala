package LeetCode.SimplifyPath

import org.scalatest.WordSpec

class SolutionTest extends WordSpec {

  "simplify path" in {
    val solution = new Solution()
    assert(solution.simplifyPath("/home/") equals "/home")
  }

  "simplify path2" in {
    val solution = new Solution()
    assert(solution.simplifyPath("/home//foo/") equals "/home/foo")
  }

  "simplify path3" in {
    val solution = new Solution()
    assert(solution.simplifyPath("/../") equals "/")
  }

  "simplify path4" in {
    val solution = new Solution()
    assert(solution.simplifyPath("/a/./b/../../") equals "/")
  }

  "simplify path5" in {
    val solution = new Solution()
    assert(solution.simplifyPath("/a/./b/../../c/") equals "/c")
  }

  "simplify path6" in {
    val solution = new Solution()
    assert(solution.simplifyPath("/a//b////c/d//././/..") equals "/a/b/c")
  }

}
