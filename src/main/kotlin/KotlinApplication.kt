fun countWords(text: String): Int {
    return if (text.isNotEmpty()) text.split(" ").filter { word -> word.all { it.isLetter() } }.size else 0
}

fun main(args: Array<String>) {
    print("Enter text: ")
    val text = readln()
    val numOfWords = countWords(text)
    println("Number of words: $numOfWords")
}
