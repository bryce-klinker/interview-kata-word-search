package kata.word.search

class HorizontalWordLocator(word: String, searchArea: Array<Array<String>>) : AbstractWordLocator(word, searchArea) {
    override fun getPoints(lineIndex: Int, lineWithWord: String): List<Point> {
        var startOfWordIndex = lineWithWord.indexOf(word)
        return word.map{ Point(lineIndex, startOfWordIndex++) }
    }

    override fun getSearchAreaAsLines(): List<String> {
        return searchArea.map { it.reduce {acc, value -> acc + value} }
    }
}