package com.dusanbartos.wordcount.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConfigFactoryTest {

    private lateinit var factory: ConfigFactory

    @BeforeEach
    fun setup() {
        factory = ConfigFactoryImpl()
    }

    @Test
    fun `process file path into config when provided`() {
        val config = factory.create(arrayOf("test_file.txt"))
        Assertions.assertEquals("test_file.txt", config.inputFilePath) { "file path not processed correctly" }
    }

    @Test
    fun `process configuration without a file path provided`() {
        val config = factory.create(arrayOf())
        Assertions.assertNull(config.inputFilePath) { "file path should be empty" }
    }
}