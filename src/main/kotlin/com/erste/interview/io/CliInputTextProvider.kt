package com.erste.interview.io

import java.io.Reader

class CliInputTextProvider(
    private val reader: Reader,
): InputTextProvider {

    override fun readInput(): String {
        return reader.readText()
    }
}