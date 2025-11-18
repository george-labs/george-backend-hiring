class DistinctFilter : SequenceFilter {
    override fun filter(sequence: Sequence<String>): Sequence<String> =
        sequence.distinct()
}