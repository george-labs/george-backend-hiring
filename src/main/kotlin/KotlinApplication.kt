import extensions.countWords
import extensions.getDividedWords


fun main(args: Array<String>) {
    print("Enter text: ")
    val words = readln().getDividedWords()
    val stopWords = FileReader().readStopWords()
    print("Number of words: ")
    println(words.countWords(stopWords))
}
