
import data.PathFileReader
import domain.WordProcessor
import ui.InputReader


///Users/melaniefreilinger/IdeaProjects/mytext.txt
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


