import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.io.ByteArrayInputStream

class KotlinApplicationTest {
    @Test
    fun `main should not throw any exceptions`() {
        val simulatedInput = "Mary had a little lamb\n"
        val inputStream = ByteArrayInputStream(simulatedInput.toByteArray())
        val originalIn = System.`in`

        runCatching {
            System.setIn(inputStream)
            assertDoesNotThrow { main() }
        }
        System.setIn(originalIn)
    }
}