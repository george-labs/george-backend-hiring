package domain

class WordCounter {

    companion object {
        val WORD_WITHOUT_NUMBERS = Regex("^[a-zA-Z]+$")
    }

    fun count(sentence: String): Int {
        val words = sentence.split(" ").filter { it.matches(WORD_WITHOUT_NUMBERS) }

        return words.count { it.isNotEmpty() }
    }


}