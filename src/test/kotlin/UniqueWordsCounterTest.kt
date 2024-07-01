import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueWordsCounterTest {
    @Test
    fun `when counting an iterable input then should return correct count`() {
        val underTest = UniqueWordsCounter()
        assertEquals(3, underTest.count(listOf("one", "two", "three", "two", "one")))
    }
}
