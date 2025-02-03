import data.Word

fun main() {
    val words = readln()
    val counter=WordCounter(words)
    println("Number of words: ${counter.countWords(counter.splitToWords())}")
}