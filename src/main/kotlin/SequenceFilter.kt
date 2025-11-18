fun interface SequenceFilter {
    fun filter(sequence: Sequence<String>): Sequence<String>
}