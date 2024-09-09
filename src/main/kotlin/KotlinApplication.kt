import iteration1.WordCounter

fun main(args: Array<String>) {
    val wordCounter = WordCounter()

    if(args.isNotEmpty()) {

    } else {
        print("Enter text:")

        val input = readlnOrNull()
        val size = wordCounter.countWords(input)

        println("Number of words: $size")
    }
}
