package kata.word.search

class ReverseHorizontalWordLocator(word: String, searchArea: Array<Array<String>>) : AbstractWordLocator(word, searchArea) {
    override fun getPoints(lineIndex: Int, lineWithWord: String): List<Point> {
        var startIndex = lineWithWord.reversed().lastIndexOf(word[0])
        return word.map{ Point(lineIndex, startIndex--) }
    }

    override fun getSearchAreaAsLines(): List<String> {
        return searchArea.map { it.reduce {acc, value -> value + acc} }
    }
}