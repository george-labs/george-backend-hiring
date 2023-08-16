package at.erste.io

import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FileInputReaderTest {

    @Test
    fun testReadNonExistingFile() {
        val reader = FileInputReader("non_existing_file.txt")
        assertThrows<FileNotFoundException> { reader.readUserInput() }
    }

    @Test
    fun testReadExistingFile() {
        val reader = FileInputReader(this.javaClass.getResource("/valid_input.txt").file)
        val fileContent = reader.readUserInput()
        assertTrue(fileContent.isNotBlank())
        assertEquals(
            "Mary had\r\n" +
                "a little\r\n" +
                "lamb",
            fileContent,
        )
    }
}
