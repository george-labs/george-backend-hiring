import data.Word

class WordCounter {
    fun countWords(words: List<Word>) = words.count { it.isWord() }

    fun countWords(words: List<Word>, stopWords: List<Word>) =
        words.count { word -> stopWords.none { word.value == it.value } && word.isWord() }

    fun countUniqueWords(words: List<Word>, stopWords: List<Word>): Int {
        val uniqueWords = mutableMapOf<String, Int>()
        words.map {
            var count = 0
            if (uniqueWords.contains(it.value))
                count = uniqueWords.get(it.value) ?: 0
            uniqueWords.put(it.value, count.inc())
        }
        return words.count { word -> uniqueWords.get(word.value) == 1 && stopWords.none { word.value == it.value } && word.isWord() }
    }
}

fun String.splitToWords() =
    split(' ').map { Word(it) }