package counter

import dto.CounterResult

class SimpleCounter(stopwords: List<String>) : AbstractCounter() {
    override fun count(input: String): CounterResult {
        val words = sanitizeInput(input)
        val filteredWords = words.filter { isInValidWord(it) }
        return CounterResult(filteredWords.size, filteredWords.toSet().size)
    }
}
