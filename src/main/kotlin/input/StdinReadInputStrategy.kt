package input

import java.io.BufferedWriter
import java.io.InputStream
import java.io.OutputStream

class StdinReadInputStrategy(
    private val outputStream: OutputStream = System.out,
    private val inputStream: InputStream = System.`in`
): ReadInputStrategy {
    override fun readInput(): String {
        outputStream.bufferedWriter().writeAndFlush("Enter text: ")
        return inputStream.bufferedReader().readText()
    }

    fun BufferedWriter.writeAndFlush(input: String) {
        write(input)
        flush()
    }

}