import at.erste.FileReader
import at.erste.WordCounter

fun main(args: Array<String>) {
    print("Enter text:")
    val stringInput = readLine()!!
    KotlinApplication().processUserInput(stringInput)
}

class KotlinApplication {
    // should be normally managed by the spring context, this will allow us also do the mocking for the integration tests
    private val fileReader: FileReader = FileReader()
    private val skippedWords: List<String> = fileReader.readByLine("/stopwords.txt")

    fun processUserInput(input: String) {
        val wordCounter = WordCounter(skippedWords)
        println("You entered: $input with ${wordCounter.countWords(input)} words")
    }
}
