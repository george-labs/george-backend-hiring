package InputReader

import java.io.InputStream
import java.util.Scanner
import java.util.zip.CheckedInputStream

class InputScanner(private val inputStream: InputStream) : InputInterface {

    private val scanner = Scanner(inputStream)

    override fun readText() = scanner.nextLine()
}
