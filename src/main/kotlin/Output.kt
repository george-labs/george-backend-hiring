import java.io.BufferedWriter
import java.io.OutputStream

fun constructMessage(count: Int): String {
    return "Number of words: $count"
}

fun printMessage(message: String, outputStream: OutputStream = System.out) {
    outputStream.bufferedWriter().writeAndFlush(message)
}

private fun BufferedWriter.writeAndFlush(input: String) {
    write(input)
    flush()
}