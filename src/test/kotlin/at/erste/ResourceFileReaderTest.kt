package at.erste

import at.erste.io.ResourceFileReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ResourceFileReaderTest {
    private val resourceFileReader = ResourceFileReader()
    private val skippedWords = listOf("and", "or", "true", "false", "1", "155")

    @Test
    fun testReadNonExistingFile() {
        val actual = resourceFileReader.readByLine("/non-existing.txt")
        assertTrue(actual.isEmpty())
    }

    @Test
    fun testEmptyFile() {
        // empty file is being read as a single line
        val actual = resourceFileReader.readByLine("/empty.txt")
        assertEquals(1, actual.size)
    }

    @Test
    fun testReadFile() {
        val actual = resourceFileReader.readByLine("/valid.txt")
        assertTrue(actual.isNotEmpty())
        assertContentEquals(skippedWords, actual)
    }
}
