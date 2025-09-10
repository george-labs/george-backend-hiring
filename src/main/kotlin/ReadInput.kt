import java.io.BufferedWriter
import java.io.OutputStream

fun readInput(
    outputStream: OutputStream = System.out,
    inputProvider: () -> String = { readln() }
): String {
    outputStream.bufferedWriter().writeAndFlush("Enter text: ")
    return inputProvider()
}

fun BufferedWriter.writeAndFlush(input: String){
    write(input)
    flush()
}