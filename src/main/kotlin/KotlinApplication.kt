import kotlin.system.exitProcess

class KotlinApplication {
    companion object {
        fun wordCount(content: String, stopWords: List<String>): Int {
            val words = content.trim().split(" ").map { it.trim() }.filter { it.isNotEmpty() }
            val regex = """[a-zA-Z]*""".toRegex()
            var wordCount = 0
            for (word in words) {
                wordCount = if (!stopWords.contains(word) && regex.matches(word) ) wordCount + 1 else wordCount
            }
            return wordCount
        }
    }
}

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Error usage: wordcount <stop words.txt file path>")
        exitProcess(1)
    }

    val file: FileReader = ReadFile(args[0])
    val stopWords = file.readLines()

    print("Enter text: ")
    val input = readln()

    val wordCount = KotlinApplication.wordCount(input, stopWords)
    println("Number of words: $wordCount")
}