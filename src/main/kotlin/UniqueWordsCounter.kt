class UniqueWordsCounter : Counter {
    override fun count(words: Iterable<String>): Int = words.toSet().count()
}
