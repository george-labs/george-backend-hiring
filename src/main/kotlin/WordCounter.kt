import data.Word

class WordCounter(private val line: String) {

    fun splitToWords() =
        line.split(' ').map { Word(it) }

    fun countWords(words: List<Word>) = words.count { it.isWord() }

    fun countWords(words: List<Word>, stopWords: List<Word>) = words.count { it.isWord(stopWords) }
}

