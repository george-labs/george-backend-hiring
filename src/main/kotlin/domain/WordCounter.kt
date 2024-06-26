package domain

class WordCounter {

    companion object {
        val WORD_WITHOUT_NUMBERS = Regex("^[a-zA-Z-]+$")
    }

    fun countAllWords(sentence: String, stopWords: Set<String> = emptySet()): Int {
        val words = extractValidWords(sentence, stopWords)
        return words.count { it.isNotEmpty() }
    }

    fun countUniqueWords(sentence: String, stopWords: Set<String> = emptySet()): Int {
        val words = extractValidWords(sentence, stopWords)
        return words.distinct().count()
    }

    private fun extractValidWords(sentence: String, stopWords: Set<String> = emptySet()): List<String> {
        if (sentence.isEmpty()) return emptyList()
        val sentenceWithoutNewLine = sentence.replace("\n", " ").replace(".", "")
        return sentenceWithoutNewLine.split(" ")
            .filter { it.matches(WORD_WITHOUT_NUMBERS) && stopWords.contains(it).not() }
    }

    fun averageWordLength(sentence: String, stopWords: Set<String>): Double {
        val listOfWords = extractValidWords(sentence, stopWords)
        return listOfWords.map { it.length }.takeIf { it.isNotEmpty() }?.average() ?: 0.0
    }


}