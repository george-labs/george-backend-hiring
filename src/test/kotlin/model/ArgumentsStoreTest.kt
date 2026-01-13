package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ArgumentsStoreTest {
    @Test
    fun `isFileProvided should return true when filePath is provided`() {
        val argumentsStore = ArgumentsStore(filePath = "path/to/file.txt")
        assertTrue(argumentsStore.isFileProvided())
    }

    @Test
    fun `isFileProvided should return false when filePath is null`() {
        val argumentsStore = ArgumentsStore(filePath = null)
        assertFalse(argumentsStore.isFileProvided())
    }

    @Nested
    inner class ToArgumentsStoreTests {
        @Test
        fun `toArgumentsStore should map first argument to filePath`() {
            val args = arrayOf("path/to/file.txt")
            val argumentsStore = args.toArgumentsStore()
            assertEquals("path/to/file.txt", argumentsStore.filePath)
            assertTrue(argumentsStore.isFileProvided())
        }

        @Test
        fun `toArgumentsStore should set filePath to null when no arguments are provided`() {
            val args = emptyArray<String>()
            val argumentsStore = args.toArgumentsStore()
            assertNull(argumentsStore.filePath)
            assertFalse(argumentsStore.isFileProvided())
        }
    }
}