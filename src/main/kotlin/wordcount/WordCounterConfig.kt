package wordcount

data class WordCounterConfig(
    val splitPattern: String = "[^A-Za-z]+",
    val includeIndex: Boolean = false
)
