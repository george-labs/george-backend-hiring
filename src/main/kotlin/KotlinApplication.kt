fun main() {
    val input = readInput()
    val words = parseInput(input)
    val count = countWords(words)
    val message = constructMessage(count)
    printMessage(message)
}

