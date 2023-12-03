import scala.collection.mutable
import scala.io.Source

import scala.util.matching.Regex
import scala.math

object Day2 extends App {
  val lines: Array[String] = Source.fromResource("Day2.txt").getLines().toArray

  var good_ids: Int = 0
  var total_power: Int = 0

  for (l <- lines) {
    val parts: Array[String] = new Regex("[;,:]").replaceAllIn(l, "").split(" ")
    println(parts.mkString(",  "))
    val colormax: mutable.Map[String, Int] = mutable.Map()
    parts.drop(2).grouped(2).foreach { case Array(count, color) =>
      colormax(color) = colormax.getOrElse(color, 0).max(count.toInt)
    }
    if (colormax("red") <= 12 && colormax("green") <= 13 && colormax("blue") <= 14) {
      good_ids += parts(1).toInt
    }
    total_power += colormax.values.product
  }

  // Part 1
  println(good_ids)

  // Part 2
  println(total_power)

}
