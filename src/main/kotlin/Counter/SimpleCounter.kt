package Counter

class SimpleCounter(private val stopwords: List<String> = listOf()) : CounterInterface {

    companion object {
        private const val allowedChars = "[a-zA-Z]+"
    }

    override fun count(input: String): Int {
        val regex = Regex("\\s+")
        if (input.isBlank()) {
            return 0
        }
        val words = input.trim().split(regex)


        var validWords = mutableListOf<String>()
        for (word in words) {
            if (isInValidWord(word)) {
                validWords.add(word)
            }
        }
        return validWords.size
    }

    private fun isInValidWord(input: String): Boolean {
        val regex = Regex(allowedChars)
        if (stopwords.contains(input)) {
            return false
        }
        return regex.matches(input)
    }
}
