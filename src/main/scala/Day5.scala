object Day5 extends App{
    case class Point(x: Int, y: Int){
      def move(c: Char) = c match {
          case 'H' => Point(x+1, y)
          case 'O' => Point(x, y+1)
          case 'V' => Point(x-1, y)
          case 'N' => Point(x, y-1)}}

  val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/5/attachments/rute.txt").mkString
  val moves = input.foldLeft(List(Point(0,0))){case (acc, v) => acc :+ acc.last.move(v)}
  val verticals = moves.sliding(2).flatMap(_.distinctBy(_.y).maxByOption(_.y)).toList
  val verticalPoints = verticals.groupMap(_.y)(_.x).values.map(_.sorted)
  val area = verticalPoints.flatMap(_.grouped(2).collect{case a::b::Nil => (b - a).abs}).sum
  println(area)
}