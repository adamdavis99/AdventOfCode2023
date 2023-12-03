import scala.io.Source
import scala.util.matching.Regex

object Day1_1 extends App {
  def getNos(input: String): Int = {
    val nosString = input.filter(_.isDigit).mkString
    (nosString.head.toString + nosString.last.toString).toInt
  }
  val filename = "Day1.txt"
  val total = Source.fromResource(filename).getLines().map(line => getNos(line)).sum

  println(total)

}
