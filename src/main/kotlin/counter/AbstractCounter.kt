package counter

import dto.CounterResult

abstract class AbstractCounter(protected val stopwords: List<String> = listOf()) : CounterInterface {

    companion object {
        protected const val allowedChars = "[a-zA-Z]+"
    }

    protected fun isInValidWord(input: String): Boolean {
        val regex = Regex(allowedChars)
        if (stopwords.contains(input)) {
            return false
        }
        return regex.matches(input)
    }

    protected fun sanitizeInput(input: String): List<String> {
        val regex = Regex("\\s+")
        return input.trim().split(regex)
    }
}
