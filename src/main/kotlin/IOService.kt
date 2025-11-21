import java.io.File
import java.io.InputStream
import java.util.*

class IOService(val inputStream: InputStream) {
    fun getInputText(args: Array<String>): String? {
        if (args.isNotEmpty()) {
            // Read from file
            val fileName = args[0]
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
}