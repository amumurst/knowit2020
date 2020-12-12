object Day10 extends App{
  val file = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/10/attachments/leker.txt")
  val input = file.getLines().map(_.split(",")).toList
  val results = input.flatMap(_.reverse.zipWithIndex).groupMapReduce(_._1)(_._2){_ + _}
  println(results.maxBy(_._2))
}