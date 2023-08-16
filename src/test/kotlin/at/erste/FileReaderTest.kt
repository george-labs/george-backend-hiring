package at.erste

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class FileReaderTest {
    private val fileReader = FileReader()
    private val skippedWords = listOf("and", "or", "true", "false", "1", "155")

    @Test
    fun testReadNonExistingFile() {
        val actual = fileReader.readByLine("/non-existing.txt")
        assertTrue(actual.isEmpty())
    }

    @Test
    fun testEmptyFile() {
        // empty file is being read as a single line
        val actual = fileReader.readByLine("/empty.txt")
        assertEquals(1, actual.size)
    }

    @Test
    fun testReadFile() {
        val actual = fileReader.readByLine("/valid.txt")
        assertTrue(actual.isNotEmpty())
        assertContentEquals(skippedWords, actual)
    }
}
