package kata.word.search

fun formatPoints(points: List<Point>): String {
    return points.joinToString(",") { it.toString() }
}