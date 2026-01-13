import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class KotlinApplicationTest {
    @Test
    fun `main should not throw any exceptions`() {
        assertDoesNotThrow { main() }
    }
}