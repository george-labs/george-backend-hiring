fun main() {

    print("Enter text: ")
    val line = readln()
    val count = WordCounter.countWords(line)
    println("Number of words: $count")

}
