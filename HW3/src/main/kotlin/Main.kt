import kotlin.math.min
import kotlin.math.max

fun main() {
    print("Enter the quarterback's name: ")
    val name = readLine()!!
    print("Enter number of pass attempts: ")
    val att = readLine()!!.toInt()
    print("Enter number of completions: ")
    val comp = readLine()!!.toInt()
    print("Enter total passing yards: ")
    val yds = readLine()!!.toInt()
    print("Enter total passing touchdowns: ")
    val td = readLine()!!.toInt()
    print("Enter number of interceptions thrown: ")
    val intr = readLine()!!.toInt()
    val a = calcCompletions(comp, att)
    val b = calcPassingYards(yds, att)
    val c = calcTouchdowns(td, att)
    val d = calcInterceptions(intr, att)
    val passerRating = calcPasserRating(a, b, c, d)


    println("$name's QB rating: %.1f".format(passerRating))
}

fun calcCompletions(completions: Int, attempts: Int): Double {
    val a = ((completions.toDouble() / attempts) - 0.3) * 5
    return min(max(a, 0.0), 2.375)
}
fun calcPassingYards(passingYards: Int, attempts: Int): Double {
    val b = ((passingYards.toDouble() / attempts) - 3.0) * 0.25
    return min(max(b, 0.0), 2.375)
}
fun calcTouchdowns(touchdowns: Int, attempts: Int): Double {
    val c = (touchdowns.toDouble() / attempts) * 20.0
    return min(max(c, 0.0), 2.375)
}
fun calcInterceptions(interceptions: Int, attempts: Int): Double {
    val d = 2.375 - ((interceptions.toDouble() / attempts) * 25.0)
    return min(max(d, 0.0), 2.375)
}
fun calcPasserRating(a: Double, b: Double, c: Double, d: Double): Double {
    return ((a + b + c + d) / 6) * 100
}