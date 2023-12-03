import scala.io.Source
import scala.util.matching.Regex

object Day1_2 extends App {

  val filename = "Day1.txt"
  var total = 0
  val re = new Regex("\\d|one|two|three|four|five|six|seven|eight|nine")
  val digits = Map(
    "one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5,
    "six" -> 6, "seven" -> 7, "eight" -> 8, "nine" -> 9,
    "1" -> 1, "2" -> 2, "3" -> 3, "4" -> 4, "5" -> 5,
    "6" -> 6, "7" -> 7, "8" -> 8, "9" -> 9
  )
  val lines = Source.fromResource(filename).getLines()
  for (line <- lines) {
    var current = List[String]()

    for (i <- 0 until line.length) {
      val found = re.findFirstIn(line.substring(i))
      if (found.isDefined) {
        current = current :+ found.get
      }
    }

    if (digits.contains(current.head)) {
      total += digits(current.head) * 10
    }

    if (digits.contains(current.last)) {
      total += digits(current.last)
    }
  }

  println(total)

}
