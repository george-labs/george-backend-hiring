import java.io.FileNotFoundException

class App(private var args: List<String>) {
    private var stopFilePath: String? = null
    private var textFilePAth: String? = null

    init {
        when(this.args.size) {
            0 -> {}
            1 -> this.textFilePAth = args[0]
            2 -> {
                this.textFilePAth = args[0]
                this.stopFilePath = args[1]
            }
            else -> {
                throw InvalidNumberOfArgsException("Error usage: wordcount [mytext.txt] [stopwords.txt]")
            }
        }
    }

    fun readStopWordsFile(): List<String>{
        if (this.stopFilePath != null) {
            return this.readFile(this.stopFilePath!!)
        }

        return listOf()
    }

    fun readTextFile(): List<String>{
        if (this.textFilePAth != null) {
            return this.readFile(this.textFilePAth!!)
        }

        return listOf()
    }

    private fun readFile(path: String): List<String> {
        val file: FileReader = ReadFile(path)

        try {
            return file.readLines().map { it.trim() }.filter { it.isNotEmpty() }
        } catch (e: FileNotFoundException) {
            throw FileNotFoundException("Error file path '$path' does not exist")
        }
    }
}