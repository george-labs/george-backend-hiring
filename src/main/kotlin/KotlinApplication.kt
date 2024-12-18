fun main() {
    print("Enter text: ")
    val userInput = readln()
    println("Number of words: ${WordCounter().count(userInput)}")
}