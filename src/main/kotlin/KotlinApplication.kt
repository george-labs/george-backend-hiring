import data.FileReader
import data.PathFileReader
import data.ResourceFileReader
import domain.StopWordReader
import domain.WordCounter
import domain.WordProcessor
import ui.InputReader

fun main(args: Array<String>) {

    val givenTextFile = args.getOrNull(0)
    if (givenTextFile != null) {

        val readfile = PathFileReader().readFile(givenTextFile)
        WordProcessor().processWords(readfile)

    } else {
        while (true) {
            println("Enter text:")
            val sentence = InputReader().readInput()

            WordProcessor().processWords(sentence)
        }

    }


}


