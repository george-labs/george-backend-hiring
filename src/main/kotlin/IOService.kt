import java.io.File
import java.io.InputStream
import java.util.*

class IOService(private val inputStream: InputStream) {
    fun getInputText(args: Array<String>): String? {
        val nonReservedArgs = args.filter { s: String -> s != "-index" }
        if (nonReservedArgs.isNotEmpty()) {
            // Read from file
            val fileName = nonReservedArgs[0]
            val file = File(fileName)
            if (!file.exists()) {
                msgln("File $fileName not found!")
                return null
            }
            return file.readLines().joinToString(" ")
        }

        // system prompt
        msg("Enter text: ")
        val scanner = Scanner(inputStream)
        return scanner.nextLine()
    }

    fun msg(msg: String) {
        print(msg)
    }

    fun msgln(msg: String) {
        println(msg)
    }

    fun showIndex(args: Array<String>): Boolean = args.any { s: String -> s == "-index" }
}