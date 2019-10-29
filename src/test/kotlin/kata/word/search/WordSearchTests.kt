/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.word.search

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import kotlin.test.Test

class WordSearchTests {

    @Test fun whenWordIsHorizontalThenWordIsReturned() {
        val puzzle = "IS\n" +
                "I,S\n" +
                "W,H"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(2))
        assertThat(output, containsString("IS: (0,0),(1,0)"))
    }

    @Test fun whenMultipleWordsInTheFirstRowAreHorizontalThenMultipleWordsAreReturned() {
        val puzzle = "IS,OF\n" +
                "I,S,A,O,F\n" +
                "A,B,C,D,E\n" +
                "F,G,H,I,J\n" +
                "K,L,M,N,O\n" +
                "P,Q,R,S,T"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(3))
        assertThat(output, containsString("IS: (0,0),(1,0)"))
        assertThat(output, containsString("OF: (3,0),(4,0)"))
    }

    @Test fun whenWordIsInTheSecondRowHorizontalThenWordIsReturned() {
        val puzzle = "IS,OF\n" +
                "A,B,C,D,E\n" +
                "I,S,A,O,F\n" +
                "F,G,H,I,J\n" +
                "K,L,M,N,O\n" +
                "P,Q,R,S,T"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(3))
        assertThat(output, containsString("IS: (0,1),(1,1)"))
        assertThat(output, containsString("OF: (3,1),(4,1)"))
    }

    @Test fun whenWordIsReversedHorizontalThenWordIsReturned() {
        val puzzle = "OF\n" +
                "A,B,C,D,E\n" +
                "I,S,A,F,O\n" +
                "F,G,H,I,J\n" +
                "K,L,M,N,O\n" +
                "P,Q,R,S,T"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(2))
        assertThat(output, containsString("OF: (4,1),(3,1)"))
    }

    @Test fun whenWordHasDuplicateLettersInTheSameRowThenWordIsReturnedWithCorrectPoints() {
        val puzzle = "ARE\n" +
                "A,B,C,D,E\n" +
                "R,A,R,E,A\n" +
                "F,G,H,I,J\n" +
                "K,L,M,N,O\n" +
                "P,Q,R,S,T"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(2))
        assertThat(output, containsString("ARE: (1,1),(2,1),(3,1)"))
    }

    @Test fun whenWordIsVerticalThenReturnsVerticalPoints() {
        val puzzle = "IS\n" +
                "I,W\n" +
                "S,H"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(2))
        assertThat(output, containsString("IS: (0,0),(0,1)"))
    }

    @Test fun whenWordIsReverseVerticalThenReturnsReverseVerticalPoints() {
        val puzzle = "IS\n" +
                "S,W\n" +
                "I,H"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(2))
        assertThat(output, containsString("IS: (0,1),(0,0)"))
    }

    @Test fun whenWordIsDiagonalThenReturnsDiagonalPoints() {
        val puzzle = "IS\n" +
                "I,W\n" +
                "W,S"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(2))
        assertThat(output, containsString("IS: (0,0),(1,1)"))
    }

    @Test fun whenMultipleDiagonalWordsThenReturnsMultipleDiagonalPoints() {
        val puzzle = "IS,OF\n" +
                "A,B,O,D,E\n" +
                "I,A,A,F,D\n" +
                "F,S,H,I,J\n" +
                "K,L,M,N,O\n" +
                "P,Q,R,S,T"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(3))
        assertThat(output, containsString("IS: (0,1),(1,2)"))
        assertThat(output, containsString("OF: (2,0),(3,1)"))
    }

    @Test fun whenMultipleReverseDiagonalWordsThenReturnsMultipleReverseDiagonalPoints() {
        val puzzle = "IS,OF\n" +
                "A,B,F,D,E\n" +
                "S,A,A,O,D\n" +
                "F,I,H,I,J\n" +
                "K,L,M,N,O\n" +
                "P,Q,R,S,T"

        val wordSearch = WordSearch(puzzle)

        val output = wordSearch.solve()

        assertThat(output.split('\n').size, `is`(3))
        assertThat(output, containsString("IS: (1,2),(0,1)"))
        assertThat(output, containsString("OF: (3,1),(2,0)"))
    }
}
