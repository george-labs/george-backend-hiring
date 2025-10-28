import org.junit.jupiter.api.Test

class KotlinApplicationTest {
    @Test
    fun testCountWords() {
        val noOfWords = countWords("Mary had a little lamb")
        assert(noOfWords == 5)
    }
}