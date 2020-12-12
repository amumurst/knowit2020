object Day11 extends App{
  val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/11/attachments/hint.txt").getLines()
  def rotateChar(c: Char, i: Int = 1) = ((c - 'a' + i) % 26 + 'a').toChar
  def run(s: String)= s.drop(1).map(rotateChar(_)).zip(s).map(a => rotateChar(a._1, a._2 - 'a')).mkString

  def containsHint(pw: String, hint: String) = 
    LazyList.iterate(pw)(run).takeWhile(_.nonEmpty).map(_.padTo(pw.size, ' ')).transpose.flatten.mkString.contains(hint)

  println(input.find(containsHint(_, "eamqia")))
}