object Day12 extends App {
    val input = scala.io.Source.fromURL("https://julekalender-backend.knowit.no/challenges/12/attachments/family.txt").mkString
    val cleaned = input.replaceAll("\\(", "( ").replaceAll("\\)", " )").split(" ")
    val levels = cleaned.foldLeft((0,Map.empty[Int, Int])){
        case ((depth, agg), ")") => (depth - 1, agg)
        case ((depth, agg), "(") => (depth + 1, agg)
        case ((depth, agg), _) => (depth, agg.updatedWith(depth)(_.orElse(Some(0)).map(_ + 1)))
    }._2
    println(levels.maxBy(_._2))
}