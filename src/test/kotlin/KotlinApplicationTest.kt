import org.junit.jupiter.api.Test

class KotlinApplicationTest {

    @Test
    fun testBasicCount() {
        val testText = "Mary had a little lamb"
        val count = countWords(testText)
        print("Count is $count")
        assert(count == 5)
    }
}