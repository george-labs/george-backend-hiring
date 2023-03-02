import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCountTests {
    @Test
    fun `getWords without stop words`() {
        Assertions.assertEquals(listOf("Mary", "had", "a", "little", "lamb"),
                getWords("Mary had a little lamb", listOf()))
        Assertions.assertEquals(listOf("Mary", "had", "a", "little", "lamb"),
                getWords("Mary had  a little lamb", listOf()))
        Assertions.assertEquals(listOf("Mary-Ann", "had", "a", "little", "lamb"),
                getWords("Mary-Ann had a little lamb", listOf()))
    }

    @Test
    fun `getWords with stop words`() {
        Assertions.assertEquals(listOf("Mary", "had", "little", "lamb"),
                getWords("Mary had a little lamb", listOf("a", "of", "the")))
        Assertions.assertEquals(listOf("Humpty-Dumpty", "sat", "wall", "Humpty-Dumpty", "had", "great", "fall"),
                getWords(
                        text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.",
                        stopWords = listOf("a", "on")))
        Assertions.assertEquals(listOf("double", "hyphen"),
                getWords(
                        text = "double--hyphen",
                        stopWords = listOf("a", "on")))
        Assertions.assertEquals(listOf("word", "between", "hyphens"),
                getWords(
                        text = "word between -hyphens-",
                        stopWords = listOf("a", "on")))
    }

    @Test
    fun reportWordCount() {
        Assertions.assertEquals(WordCountReport(totalCount = 9, uniqueCount = 7),
                reportWordCounts(listOf("Humpty", "Dumpty", "sat", "wall", "Humpty", "Dumpty", "had", "great", "fall")))
        Assertions.assertEquals(WordCountReport(totalCount = 7, uniqueCount = 6),
                reportWordCounts(listOf("Humpty-Dumpty", "sat", "wall", "Humpty-Dumpty", "had", "great", "fall")))
    }
}