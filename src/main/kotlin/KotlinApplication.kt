import domain.WordCounter
import ui.InputReader

fun main(args: Array<String>) {

    while (true) {
        println("Enter text:")
        val sentence = InputReader().readInput()
        val countedWords = WordCounter().wordCounter(sentence)
        println("Number of words: $countedWords")
    }


}

