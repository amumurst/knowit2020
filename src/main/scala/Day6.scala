object Day6 extends App{
  val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/6/attachments/godteri.txt").mkString
  val sortedBoxes = input.split(",").map(_.toInt).sorted.reverse
  val optimal = sortedBoxes.scanLeft(0){_+_}.zipWithIndex.findLast(_._1 % 127 == 0)
  println(optimal.map{case (v, i) => (v / 127, i)}.mkString)
}
//Some((975,9886))
