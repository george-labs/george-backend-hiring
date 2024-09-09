import iteration1.WordCounter

fun main() {
    val wordCounter = WordCounter()
    print("Enter text:")

    val input = readlnOrNull()
    val size = wordCounter.countWords(input)

    println("Number of words: $size")
}