package kata.word.search

class ReverseDiagonalWordLocator(private val word: String, private val searchArea: Array<Array<String>>) : WordLocator {
    override fun locate(): String {
        val points = findPointsForWord()
        return if (points.isEmpty()) "" else "$word: ${formatPoints(points)}\n"
    }

    private fun findPointsForWord(): List<Point> {
        for (row in searchArea.indices) {
            for (column in searchArea.indices) {
                val matchingPoints = getMatchingPoints(row, column)
                if (matchingPoints.isEmpty()) {
                    continue
                }

                return matchingPoints
            }
        }

        return emptyList()
    }

    private fun getMatchingPoints(row: Int, column: Int): List<Point> {
        val points = mutableListOf<Point>()
        for (characterIndex in word.indices) {
            val currentRow = row - characterIndex
            val currentColumn = column - characterIndex
            val currentCharacter = word[characterIndex].toString()
            val point = getPoint(currentRow, currentColumn, currentCharacter)
            if (point == emptyPoint()) {
                return emptyList()
            }
            points.add(point)
        }
        return points
    }

    private fun getPoint(row: Int, column: Int, letter: String): Point {
        if (isOutsideSearchArea(row, column))
            return emptyPoint()

        if (letter == searchArea[row][column]) {
            return Point(row, column)
        }

        return emptyPoint()
    }

    private fun isOutsideSearchArea(row: Int, column: Int): Boolean {
        return row < 0
                || column < 0
    }
}