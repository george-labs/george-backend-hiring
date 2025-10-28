import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    @Test
    fun testCountWords() {
        val noOfWords = countWords("Mary had a little lamb")
        assert(noOfWords == 4)
    }

    @Test
    fun testCountWordsEmpty() {
        val noOfWords = countWords("")
        assert(noOfWords == 0)
    }

    @Test
    fun testCountStopWords() {
        val stopWordsText = getStopWords().joinToString(" ")
        val noOfWords = countWords(stopWordsText)
        assert(noOfWords == 0)
    }
}