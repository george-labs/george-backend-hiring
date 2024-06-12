abstract class WordsCountWriter(private val prefix: String) {
    fun write(count: Int) {
        print("$prefix$count")
    }
}

class ConsoleWordsCountWriter : WordsCountWriter("Number of words: ")

class ConsoleUniqueWordsCountWriter : WordsCountWriter(", unique: ")
