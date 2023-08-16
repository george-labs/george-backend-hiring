import at.erste.FileReader
import at.erste.WordCounter

fun main(args: Array<String>) {
    print("Enter text:")
    val stringInput = readLine()!!

    val wordCounter = WordCounter(FileReader().readByLine("/stopwords.txt"))
    println("You entered: $stringInput with ${wordCounter.countWords(stringInput)} words")
}

class KotlinApplication
