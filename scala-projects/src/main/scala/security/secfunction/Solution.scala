package security.secfunction

import java.io.PrintWriter

object Solution {

  def calculate(x: Int): Int = {
    x*x

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val x = stdin.readLine.trim.toInt

    val result = calculate(x)

    printWriter.println(result)

    printWriter.close()
  }

}
