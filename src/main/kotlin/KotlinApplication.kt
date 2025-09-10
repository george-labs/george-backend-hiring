import java.io.BufferedWriter
import java.io.OutputStream

fun main() {

}

fun readInput(
    outputStream: OutputStream = System.out,
    inputProvider: () -> String = { readln() }
): String {
    outputStream.bufferedWriter().writeAndFlush("Enter text: ")
    return inputProvider()
}

private fun BufferedWriter.writeAndFlush(input: String){
    write(input)
    flush()
}