package kata.word.search

abstract class AbstractWordLocator(protected val word: String, protected val searchArea: Array<Array<String>>) : WordLocator {
    override fun locate(): String {
        val lines = getSearchAreaAsLines()
        val lineWithWord = lines.find { it.contains(word) } ?: return ""
        val lineIndex = lines.indexOf(lineWithWord)
        val points = getPoints(lineIndex, lineWithWord)
        return "$word: ${formatPoints(points)}\n"
    }

    abstract fun getSearchAreaAsLines(): List<String>

    abstract fun getPoints(lineIndex: Int, lineWithWord: String): List<Point>
}