class WordCounter(private val stopWords: Set<String>) {

    fun countWords(input: String): Int = input
        .split(" ", "\n", ".")
        .asSequence()
        .filter { it.matches(Regex("[a-zA-Z]+")) }
        .filter { !stopWords.contains(it) }
        .count()

}
