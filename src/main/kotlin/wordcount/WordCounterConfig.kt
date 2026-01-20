package wordcount

/**
 * Configuration that represents a static per environment config
 */
data class WordCounterConfig(
    val splitPattern: String = "[^A-Za-z]+"
)
