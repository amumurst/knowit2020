
object Day4 extends App{
    val file = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/4/attachments/leveringsliste.txt").getLines()
    val cleanLines = file.mkString(", ").split(", ")
    val all = cleanLines.groupMapReduce(_.takeWhile(_ !=':'))(_.dropWhile(_ !=':').drop(2).toInt){_+_}
    val result = List(all("melk")/3, all("mel")/3, all("sukker")/2, all("egg")).min
    println(result)
}