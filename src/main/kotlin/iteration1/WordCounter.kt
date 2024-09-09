package iteration1

class WordCounter {

    private val stopWords: MutableSet<String> = mutableSetOf()

    init {
        val wordsText = object {}.javaClass.getResource("/stopwords.txt")?.readText()
        wordsText?.split("\n")?.map { it.lowercase() }?.forEach(stopWords::add)
    }

    fun stopWordsCount():Int = stopWords.size

    fun countUniqueWords(sentence: String?): Int {
        sentence?.let {
            val regex = "\\b[a-zA-Z]+\\b".toRegex()
            val set = regex.findAll(sentence).filter {
                !stopWords.contains(it.value.trim())
            }.map { it.value.lowercase() }.toSet()

            return set.size
        }

        return 0
    }

    fun countWords(sentence: String?): Int {
        sentence?.let {
            val regex = "\\b[a-zA-Z]+\\b".toRegex()
            val matches = regex.findAll(sentence).filter {
                !stopWords.contains(it.value.trim())
            }

            return matches.count()
        }

        return 0
    }
}