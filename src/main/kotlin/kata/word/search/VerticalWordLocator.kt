package kata.word.search

class VerticalWordLocator(word: String, searchArea: Array<Array<String>>) : AbstractWordLocator(word, searchArea) {
    override fun getPoints(lineIndex: Int, lineWithWord: String): List<Point> {
        var startIndex = lineWithWord.indexOf(word)
        return word.map{ Point(startIndex++, lineIndex) }
    }

    override fun getSearchAreaAsLines(): List<String> {
        val lines = mutableListOf<String>()
        for (column in searchArea.indices) {
            val lineBuilder = StringBuilder()
            for (row in searchArea.indices) {
                lineBuilder.append(searchArea[row][column])
            }
            lines.add(lineBuilder.toString())
        }
        return lines
    }
}
