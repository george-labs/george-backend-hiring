package domain

class WordCounter {

    companion object {
        val WORD_WITHOUT_NUMBERS = Regex("^[a-zA-Z]+$")
    }

    fun count(sentence: String, stopWords: Set<String> = emptySet()): Int {
        val words = sentence.split(" ").filter { it.matches(WORD_WITHOUT_NUMBERS) && stopWords.contains(it).not() }

        return words.count { it.isNotEmpty() }
    }


}