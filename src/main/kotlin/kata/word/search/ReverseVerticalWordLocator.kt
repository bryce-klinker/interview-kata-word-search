package kata.word.search

class ReverseVerticalWordLocator(word: String, searchArea: Array<Array<String>>) : AbstractWordLocator(word, searchArea) {
    override fun getPoints(lineIndex: Int, lineWithWord: String): List<Point> {
        return word.map{Point(lineWithWord.reversed().indexOf(it), lineIndex)}
    }

    override fun getSearchAreaAsLines(): List<String> {
        val lines = mutableListOf<String>()
        for (column in searchArea.indices) {
            val lineBuilder = StringBuilder()
            for (row in searchArea.indices) {
                lineBuilder.append(searchArea[row][column])
            }
            lines.add(lineBuilder.toString().reversed())
        }
        return lines
    }

}
