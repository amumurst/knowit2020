object Day3 extends App{
  def readUrl(u: String) = scala.io.Source.fromURL(u).getLines().toList
  def shiftList(l: List[String]) = l.zipWithIndex.map { case (line, i) => line.drop(i) + line.take(i) }.transpose.map(_.mkString)
  val matrix  = readUrl("https://julekalender-backend.knowit.no/challenges/3/attachments/matrix.txt")
  val words = readUrl("https://julekalender-backend.knowit.no/challenges/3/attachments/wordlist.txt")

  val permutations = matrix ++ matrix.transpose.map(_.mkString) ++ shiftList(matrix) ++ shiftList(matrix.map(_.reverse))
  val filteredWords = words.filterNot(word => permutations.exists(w => w.contains(word) || w.contains(word.reverse)))
  println(filteredWords.sorted.mkString(","))
}