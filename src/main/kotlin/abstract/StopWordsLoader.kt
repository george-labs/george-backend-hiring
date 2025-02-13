package abstract

interface StopWordsLoader {
    abstract fun getStopWords(): Set<String>
}