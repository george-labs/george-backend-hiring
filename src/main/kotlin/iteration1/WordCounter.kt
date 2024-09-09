package iteration1

class WordCounter() {

    private val stopwords: MutableSet<String> = mutableSetOf()

    init {
        val wordsText = object {}.javaClass.getResource("/stopwords.txt")?.readText()
        wordsText?.split("\n")?.forEach(stopwords::add)
    }

    fun stopWordsCount():Int = stopwords.size

    fun countWords(sentence: String?): Int {
        sentence?.let {
            val regex = "\\b[a-zA-Z]+\\b".toRegex()
            val matches = regex.findAll(sentence).filter {
                !stopwords.contains(it.value.trim())
            }

            return matches.count()
        }

        return 0
    }


}