import inputReader.InputReader
import stopWorldLoader.StopWordLoader

class WordCounter(
    private val stopWordLoader: StopWordLoader,
    private val inputReader: InputReader,
) {
    private val stopWords = stopWordLoader.loadFromResources()

    fun countWordsInText(): Int {
        val inputText = inputReader.read()
        return countWords(inputText)
    }

    private fun countWords(input: String): Int {
        val potentialWords = input.split(" ", "\t", System.lineSeparator())
        val validWords = potentialWords
            .filter { it.isNotBlank() }
            .filter { word -> word.none { !it.isLetter() } && !stopWords.contains(word) }
        return validWords.size
    }
}