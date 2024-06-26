import data.PathFileReader
import data.ResourceFileReader
import domain.StopWordReader
import domain.WordCounter
import domain.WordProcessor
import ui.InputReader


///Users/melaniefreilinger/IdeaProjects/mytext.txt
fun main(args: Array<String>) {

    val wordProcessor =
        WordProcessor(
            wordCounter = WordCounter(),
            stopWordReader = StopWordReader(ResourceFileReader())
        )

    val givenTextFile = args.getOrNull(0)
    if (givenTextFile != null) {
        val readfile = PathFileReader().readFile(givenTextFile)
        wordProcessor.processWords(readfile)
    } else {
        while (true) {
            println("Enter text:")
            val sentence = InputReader().readInput()

            wordProcessor.processWords(sentence)
        }
    }
}


