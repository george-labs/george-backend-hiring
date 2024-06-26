package domain

class WordCounter {

    companion object {
        val WORD_WITHOUT_NUMBERS = Regex("^[a-zA-Z-]+$")
    }

    fun countAllWords(sentence: String, stopWords: Set<String> = emptySet()): Int {
        val words = processSentence(sentence, stopWords)
        return words.count { it.isNotEmpty() }
    }

    fun countUniqueWords(sentence: String, stopWords: Set<String> = emptySet()): Int {
        val words = processSentence(sentence, stopWords)
        return words.distinct().count()
    }

    private fun processSentence(sentence: String, stopWords: Set<String> = emptySet()): List<String> {
        val sentenceWithoutNewLine = sentence.replace("\n", " ").replace(".", "")
        return sentenceWithoutNewLine.split(" ")
            .filter { it.matches(WORD_WITHOUT_NUMBERS) && stopWords.contains(it).not() }
    }


}