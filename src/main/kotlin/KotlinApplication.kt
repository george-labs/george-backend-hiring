fun main() {
    print("Enter text:")
    val enteredText = readln()

    val wordCount = countWords(enteredText)

    print("Number of words: $wordCount")

    return
}

fun countWords(text: String): Int {
    val pattern = Regex("[A-Za-z]*")
    return pattern.findAll(text).count()
}