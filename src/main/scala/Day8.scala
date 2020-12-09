case class Point(x:Int, y: Int, time: Double)
object Day8 extends App{
  val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/8/attachments/input.txt")
  val (places, trip) = input.getLines().toList.splitAt(50)
  val locations = places.map{case s"$name: ($x, $y)" => (name -> Point(x.toInt, y.toInt, 0))}.toMap

  def rangeF(f: Int, t: Int) = (if(f < t) Range.inclusive(f, t) else (Range(t, f).reverse)).toSet
  def movesFromTo(from: Point, to: Point) =
      (rangeF(from.x, to.x).map(Point(_, from.y, 0)) ++ rangeF(from.y, to.y).map(Point(to.x, _, 0)))
        .filterNot(_ == from.copy(time = 0))
  def timeDialation(santaPos: Point)(point: Point) = {
    val dist = (point.x-santaPos.x).abs + (point.y-santaPos.y).abs
    val delta = if(dist==0) 0 else if (dist < 5) 0.25 else if (dist < 20) 0.5 else if (dist < 50) 0.75 else 1
    point.copy(time = point.time + delta)
  }
  val endMap = trip.foldLeft((locations, Point(0,0,0))){case ((map, santa), loc) => 
    val newMap = movesFromTo(santa, map(loc)).foldLeft(map){case (state, santa) => 
      state.mapValues(timeDialation(santa)).toMap
    }
    (newMap, newMap(loc))
  }
  val times = endMap._1.values.map(_.time)
  println(times.max - times.min)
}