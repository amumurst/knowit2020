object Day1 extends App {
    val url    = "https://julekalender-backend.knowit.no/challenges/1/attachments/numbers.txt"
    val actual = scala.io.Source.fromURL(url).mkString.split(",").flatMap(_.toIntOption)
    println((1 to 100000).sum - actual.sum)
}