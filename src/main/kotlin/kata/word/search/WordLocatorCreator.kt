package kata.word.search

import kotlin.streams.toList

fun createAllWordLocators(puzzle: String): List<WordLocator> {

    val searchArea = createSearchArea(puzzle)
    return puzzle.split('\n')[0].split(',')
            .map { w -> createWordLocatorsForWord(w, searchArea) }
            .flatten()

}

private fun createWordLocatorsForWord(word: String, searchArea: Array<Array<String>>): List<WordLocator> {
    return listOf(
            HorizontalWordLocator(word, searchArea),
            ReverseHorizontalWordLocator(word, searchArea),
            VerticalWordLocator(word, searchArea),
            ReverseVerticalWordLocator(word, searchArea),
            DiagonalWordLocator(word, searchArea),
            ReverseDiagonalWordLocator(word, searchArea)
    )
}

private fun createSearchArea(puzzle: String): Array<Array<String>> {
    val contents = puzzle.split('\n').stream().skip(1).toList()
    val height = contents.size

    val width = contents[0].split(',').size
    val searchArea = Array(height) { Array(width) {""} }

    for (line in 0 until height) {
        val characters = contents[line].split(',')
        for (character in 0 until width) {
            searchArea[line][character] = characters[character]
        }
    }
    return searchArea;
}

