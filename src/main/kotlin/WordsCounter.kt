class WordsCounter : Counter {
    override fun count(words: Iterable<String>): Int = words.count()
}
