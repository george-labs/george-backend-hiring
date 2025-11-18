class NonStopWordsFilter(val stopWords: List<String>) : SequenceFilter {
    override fun filter(sequence: Sequence<String>): Sequence<String> =
        sequence.filter { !stopWords.contains(it) }
}