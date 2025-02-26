package com.dusanbartos.wordcount.data

import kotlin.io.path.Path


interface FileReader {
    fun read(filename: String): String
}

class PathFileReader : FileReader {

    override fun read(filename: String): String =
        try {
            Path(filename).toFile().readText()
        } catch (e: Throwable) {
            System.err.println("Error processing file '$filename' - ${e.message ?: "unknown error"}")

            throw IllegalArgumentException("File '$filename' could not be accessed. Please check if you have rights" +
                    " to access the file or if the file exists.")
        }
}