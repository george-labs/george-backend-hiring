import data.FileReader
import data.ResourceFileReader
import domain.StopWordReader
import domain.WordCounter
import ui.InputReader

fun main(args: Array<String>) {

    val givenTextFile = args.getOrNull(1)
    if (givenTextFile != null) {



    } else {
        while (true) {
            println("Enter text:")
            val sentence = InputReader().readInput()

            val stopWordReader = StopWordReader(ResourceFileReader())
            val stopWords = stopWordReader.getStopWords("stopwords.txt")

            val countedWords = WordCounter().count(sentence, stopWords)
            println("Number of words: $countedWords")
        }

    }


}

private fun

