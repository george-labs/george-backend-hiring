package com.dusanbartos.wordcount.data

import org.junit.jupiter.api.Assertions


class MockedWriter : Writer {

    private val builder = StringBuilder()

    override fun print(message: String) {
        builder.append(message)
    }

    override fun println(message: String) {
        builder.append(message)
        builder.append("\n")
    }

    fun assertEquals(message: String) {
        Assertions.assertEquals(builder.toString().dropLastWhile { it == '\n' }, message) { "Writer not matching '$message'" }
    }
}