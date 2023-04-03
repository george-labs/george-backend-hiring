fun main() {

    print("Enter text: ")
    val line = readln()
    val counter = WordCounter(setOf())
    val count = counter.countWords(line)
    println("Number of words: $count")

}
