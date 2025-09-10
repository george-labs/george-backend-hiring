package input

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException

class FileBasedReadInputStrategyTest {

    private val testFilePath =
        FileBasedReadInputStrategyTest::class.java.getResource("/test.txt")?.path ?: error("Resource not found")
    private val strategy = FileBasedReadInputStrategy(testFilePath)

    @Test
    fun `reads the contents of the provided file`() {
        val expected = "Mary had\na little\nlamb"
        assertEquals(expected, strategy.readInput())
    }

    @Test
    fun `throws FileNotFoundException, if provided file is not found`() {
        val strategy = FileBasedReadInputStrategy("notFound.txt")
        assertThrows<FileNotFoundException> { strategy.readInput() }
    }
}