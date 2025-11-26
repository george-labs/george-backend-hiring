import extensions.countWords
import extensions.getDividedWords


fun main(args: Array<String>) {
    val fileReader = FileReader()
    var words = fileReader.readWords(args.asList().firstOrNull())
    val stopWords = fileReader.readStopWords()
    if (words == null) {
        print("Enter text: ")
        words = readln().getDividedWords()
    }

    print("Number of words: ")
    println(words.countWords(stopWords))

}
