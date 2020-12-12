object Day9 extends App{
    val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/9/attachments/elves.txt").getLines().toList
    val startState = input.zipWithIndex.foldLeft(Set.empty[(Int, Int)]){case (set, (s, y)) => 
        s.zipWithIndex.collect{case ('F', x) => (x, y)}.toSet ++ set}

    val size = input.size
    def neighs(p: (Int, Int)) = Set((p._1, p._2+1), (p._1, p._2-1), (p._1+1, p._2), (p._1-1, p._2))
        .filter(p => p._1 > -1 && p._2 > -1 && p._1 < size && p._2 < size)

    def delta(s: Set[(Int, Int)]) = s.filter(p => neighs(p).size - neighs(p).count(s.contains) > 1)
    val days = Iterator.iterate(startState)(s => s -- delta(s)).zipWithIndex
    println(days.find(s => delta(s._1).isEmpty).map(_._2 + 1))
}
//158