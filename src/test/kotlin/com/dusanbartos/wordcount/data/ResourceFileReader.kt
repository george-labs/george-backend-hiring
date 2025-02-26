package com.dusanbartos.wordcount.data

class ResourceFileReader : FileReader {

    private val classLoader = this::class.java.classLoader

    override fun read(filename: String): String =
        classLoader.getResourceAsStream(filename)
            ?.use { it.bufferedReader().readLines() }
            ?.joinToString(" ")
            .orEmpty()
}