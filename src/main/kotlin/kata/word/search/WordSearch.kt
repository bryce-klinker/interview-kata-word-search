/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.word.search

class WordSearch(puzzle: String) {
    private val locators: List<WordLocator> = createAllWordLocators(puzzle)

    fun solve(): String {
        val resultBuilder = StringBuilder()
        for (word in locators) {
            resultBuilder.append(word.locate())
        }
        return resultBuilder.toString()
    }
}

