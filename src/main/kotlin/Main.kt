fun main() {
    println("Enter your text:")
    val input = readLine() ?: ""

    val wordCount = countWords(input)

    println("Word count: $wordCount")
}