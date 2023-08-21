import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {
    @ParameterizedTest
    @CsvSource(
        "      word  word     ,2,1",
        "word word,2,1",
        "word.    word,2,1",
        "word word3    word,2,1",
        "word3word  word., 1,1",
        "there are 3    cats,3,3",
        "please turn on the lights.,3,3",
        "    the  3lights are turned off and a washing machine.,5,5",
        "Washing-Machine is turned off please turn washing-machine on,8,6",
        "hello Hello world3      world,3,2"
    )
    fun testWordCount(input: String, expectedWordsCount: Int, expectedUniqueWordsCount: Int) {
        val stopWords = listOf("the","a", "on", "off")
        val (wordsCount, uniqueWordsCount) = WordCounter.wordCount(input, stopWords)
        assert(expectedWordsCount == wordsCount) {
            "WordCounter.wordCount (wordsCount): Expected $expectedWordsCount, Got $wordsCount"
        }
        assert(expectedUniqueWordsCount == uniqueWordsCount) {
            "WordCounter.wordCount (uniqueWordsCount): Expected $expectedUniqueWordsCount, Got $uniqueWordsCount"
        }
    }
}