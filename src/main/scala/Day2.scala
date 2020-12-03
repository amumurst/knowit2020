object Day2 extends App{
    def isPrime(n: Int) = (2 to math.sqrt(n).toInt).forall(n % _ !=0)
    val resultStream = LazyList.from(0).scanLeft((0,0,0)){case ((pp, dr, de), n) => 
        val newP = if(isPrime(n)) n else pp
        if(dr>0) (newP, dr - 1, de)
        else if (n.toString.contains('7')) (newP, newP, de)
        else (newP, dr, de + 1)
    }
  println(resultStream.drop(5433000).head._3)
}
