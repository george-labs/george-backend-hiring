interface WordConsumer<T> {

    fun accept(words: List<String>): T
}

class WordsCounterConsumer : WordConsumer<Int> {
    override fun accept(words: List<String>): Int = words.size
}

class WordsAverageConsumer : WordConsumer<Double> {
    override fun accept(words: List<String>): Double {
        if (words.isEmpty()) {
            return 0.0
        }
        var counter = 0.0
        words.forEach { counter += it.length }
        return counter / words.size.toDouble()
    }
}

class WordsUniqueConsumer : WordConsumer<Int> {
    override fun accept(words: List<String>): Int = words.toSet().size
}

class WordsIndexConsumer : WordConsumer<List<String>> {
    override fun accept(words: List<String>): List<String> = words.sortedBy { it.lowercase() }
}
