package kata.word.search

class Point(private val row: Int, private val column: Int) {
    override fun toString(): String {
        return "($column,$row)"
    }

    override fun equals(other: Any?): Boolean {
        return other is Point
                && other.row == row
                && other.column == column
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        return result
    }
}

fun emptyPoint(): Point {
    return Point(-1, -1)
}