import data.Word

class WordCounter {
    fun countWords(words: List<Word>) = words.count { it.isWord() }

    fun countWords(words: List<Word>, stopWords: List<Word>) =
        words.count { word -> stopWords.none { word.value == it.value } && word.isWord() }

    fun countUniqueWords(words: List<Word>, stopWords: List<Word>): Int {
        val uniqueWords = mutableMapOf<String, Int>()
        words.map {
            var count = 0
            if (uniqueWords.contains(it.value)) {
                count = uniqueWords.get(it.value) ?: 0
                uniqueWords.replace(it.value, count.inc())
            } else {
                uniqueWords.put(it.value, count.inc())
            }
        }
        return words.count { word -> uniqueWords.get(word.value) == 1 && stopWords.none { word.value == it.value } && word.isWord() }
    }

    fun averageWordLength(words: List<Word>): Float {
        var charCount = 0f
        words.map { word ->
            if (word.isWord())
                charCount += word.value.length
        }
        return charCount.div(countWords(words).toFloat())
    }

    fun averageWordLength(words: List<Word>, stopWords: List<Word>): Float {
        var charCount = 0f
        words.map { word ->
            if (stopWords.none { word.value == it.value } && word.isWord())
                charCount += word.value.length
        }
        return charCount.div(countWords(words, stopWords).toFloat())
    }
}

fun String.splitToWords() =
    split(' ').map { Word(it) }