package input

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class StdinReadInputStrategyTest {

    private val bytearrayOutStream = ByteArrayOutputStream()

    @Test
    fun `returns the input that the user provided`() {
        createStrategyAndAssertInputString("Mary had a little lamb")

    }

    @Test
    fun `can support an empty string input`() {
        createStrategyAndAssertInputString("")
    }

    private fun createStrategyAndAssertInputString(input: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val strategy = StdinReadInputStrategy(bytearrayOutStream, inputStream)

        assertEquals(input, strategy.readInput())
        assertEquals("Enter text: ", String(bytearrayOutStream.toByteArray()))
    }
}