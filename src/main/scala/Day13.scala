object Day13 extends App{
  val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/13/attachments/text.txt").mkString
  val res = input.foldLeft(("", Map.empty[Char, Int])){case ((acc, buff), c) =>
      (if (c - 'a'== buff.getOrElse(c, 0)) acc + c else acc, 
        buff.updatedWith(c)(_.orElse(Some(0)).map(_+1)))}
  println(res._1)
}
