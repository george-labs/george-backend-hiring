package com.erste.interview.io

import java.io.File
import kotlin.system.exitProcess

class FileInputTextProvider(
    val filepath: String
) : InputTextProvider {

    override fun readInput(): String {
        val file = File(filepath)
        if (!file.exists()) {
            println("Provided file does not exist")
            exitProcess(1)
        }

        return file.readText()
    }

}
