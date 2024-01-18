
fun main(args: Array<String>) {
    print("Enter text: ")
    val inputText = readln()

    val wordCount = countWords(inputText)
    println("Number of words: $wordCount")
}

fun countWords(text: String): Int {
    return "([a-zA-Z]+)".toRegex().findAll(text).count()
}
