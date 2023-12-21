fun countWords(text: String): Int {
    return text.split(" ").filter { word -> word.all { it.isLetter() } }.size
}

fun main(args: Array<String>) {
    print("Enter text: ")
    val text = readln()
    val numOfWords = countWords(text)
    println("Number of words: $numOfWords")
}
