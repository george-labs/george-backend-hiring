package com.dusanbartos.wordcount.data

import org.junit.jupiter.api.Test

class ResourceStopWordReaderTest {

    @Test
    fun `should return empty set for non-existing resource name`() {
        val wordSet = ResourceStopWordReader().read("non-existent")
        assert(wordSet.isEmpty()) { "word set should be empty" }
    }
}