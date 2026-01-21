package wordcount

data class WordCounterConfig(
    val splitPattern: String = "[^A-Za-z]+"
)
