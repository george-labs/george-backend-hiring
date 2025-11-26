import extensions.countWords
import extensions.getDividedWords


fun main(args: Array<String>) {
    print("Enter text: ")
    val words = readln().getDividedWords()
    print("Number of words: ")
    println(words.countWords(FileReader().readStopWords()))
}
