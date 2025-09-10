import java.io.BufferedWriter
import java.io.OutputStream

fun constructMessage(count: Int, uniqueCount: Int): String {
    return buildString {
        append("Number of words: $count")
        append(", unique: $uniqueCount")
    }
}

fun printMessage(message: String, outputStream: OutputStream = System.out) {
    outputStream.bufferedWriter().writeAndFlush(message)
}

private fun BufferedWriter.writeAndFlush(input: String) {
    write(input)
    flush()
}