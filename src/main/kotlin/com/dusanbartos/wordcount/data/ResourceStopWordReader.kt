package com.dusanbartos.wordcount.data

interface StopWordReader {
    fun read(name: String): Set<String>
}

class ResourceStopWordReader : StopWordReader {

    private val classLoader = this::class.java.classLoader

    override fun read(name: String): Set<String> =
        classLoader.getResourceAsStream(name)
            ?.use { it.bufferedReader().readLines() }
            ?.toSet()
            // this should never happen, but if we want to be double-safe, let's print a message in console
            ?: emptySet<String>().also { System.err.println("Stopword file was not found") }
}