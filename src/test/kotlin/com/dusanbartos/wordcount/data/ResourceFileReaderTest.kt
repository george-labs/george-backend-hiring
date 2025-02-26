package com.dusanbartos.wordcount.data

import org.junit.jupiter.api.Test

class ResourceFileReaderTest {

    @Test
    fun `should return empty set for non-existing resource name`() {
        val wordSet = ResourceFileReader().read("non-existent")
        assert(wordSet.isEmpty()) { "word set should be empty" }
    }
}