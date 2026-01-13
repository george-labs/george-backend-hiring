package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ArgumentsStoreTest {
    @Nested
    inner class FileProvidedTests {
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

        @Test
        fun `toArgumentsStore should set indexed to true when -index flag is present`() {
            val args = arrayOf("path/to/file.txt", "-index")
            val argumentsStore = args.toArgumentsStore()
            assertTrue(argumentsStore.indexed)
        }

        @Test
        fun `toArgumentsStore should set indexed to false when -index flag is absent`() {
            val args = arrayOf("path/to/file.txt")
            val argumentsStore = args.toArgumentsStore()
            assertFalse(argumentsStore.indexed)
        }

        @Test
        fun `toArgumentsStore should handle case insensitive -index flag`() {
            val args = arrayOf("path/to/file.txt", "-InDeX")
            val argumentsStore = args.toArgumentsStore()
            assertTrue(argumentsStore.indexed)
        }

        @Test
        fun `toArgumentsStore should parse indexed flag with no filePath provided`() {
            val args = arrayOf("-index")
            val argumentsStore = args.toArgumentsStore()
            assertTrue(argumentsStore.indexed)
        }

        @Test
        fun `filePath should be parsed correctly even if it's located not at first position`() {
            val args = arrayOf("-InDeX", "path/to/file.txt")
            val argumentsStore = args.toArgumentsStore()
            assertTrue(argumentsStore.indexed)
            assertEquals("path/to/file.txt", argumentsStore.filePath)
        }

        @Test
        fun `toArgumentsStore should parse dictionaryFilePath when -dictionary flag is present`() {
            val args = arrayOf("path/to/file.txt", "-index", "-dictionary=path/to/dictionary.txt")
            val argumentsStore = args.toArgumentsStore()
            assertEquals("path/to/dictionary.txt", argumentsStore.dictionaryFilePath)
        }

        @Test
        fun `toArgumentsStore should set dictionaryFilePath to null when -dictionary flag is absent`() {
            val args = arrayOf("path/to/file.txt", "-index")
            val argumentsStore = args.toArgumentsStore()
            assertNull(argumentsStore.dictionaryFilePath)
        }

        @Test
        fun `toArgumentsStore should ignore dictionary flag if index flag is not provided`() {
            val args = arrayOf("path/to/file.txt", "-dictionary=path/to/dictionary.txt")
            val argumentsStore = args.toArgumentsStore()
            assertNull(argumentsStore.dictionaryFilePath)
        }
    }
}