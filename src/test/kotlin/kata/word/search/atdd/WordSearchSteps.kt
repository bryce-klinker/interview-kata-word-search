package kata.word.search.atdd

import io.cucumber.java8.En
import kata.word.search.WordSearch
import org.hamcrest.CoreMatchers.containsString
import java.lang.RuntimeException
import org.junit.Assert.assertThat as assertThat

class WordSearchSteps : En {
    var wordSearch: WordSearch? = null
    var words: String? = null

    init {
        Given("a fifteen by fifteen word search") {
            val puzzle =
                    "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA\n" +
                    "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E\n" +
                    "L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G\n" +
                    "H,S,U,P,J,P,R,J,D,H,S,B,X,T,G\n" +
                    "B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E\n" +
                    "A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D\n" +
                    "S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F\n" +
                    "B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z\n" +
                    "O,K,R,I,K,A,M,M,R,M,F,B,A,P,P\n" +
                    "N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S\n" +
                    "E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K\n" +
                    "S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D\n" +
                    "T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K\n" +
                    "O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H\n" +
                    "W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S\n" +
                    "K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B"

            wordSearch = WordSearch(puzzle)
        }

        When("I find the words") {
            if (wordSearch == null)
                throw RuntimeException("Word search has not been initialized")

            words = wordSearch?.solve()
        }

        Then("I should see all words in the word search") {
            assertThat(words, containsString("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)"))
            assertThat(words, containsString("KHAN: (5,9),(5,8),(5,7),(5,6)"))
            assertThat(words, containsString("KIRK: (4,7),(3,7),(2,7),(1,7)"))
            assertThat(words, containsString("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)"))
            assertThat(words, containsString("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)"))
            assertThat(words, containsString("SULU: (3,3),(2,2),(1,1),(0,0)"))
            assertThat(words, containsString("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)"))
        }
    }
}