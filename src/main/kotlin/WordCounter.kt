import data.Word

class WordCounter {
    fun countWords(words: List<Word>) = words.count { it.isWord() }

    fun countWords(words: List<Word>, stopWords: List<Word>) =
        words.count { word -> stopWords.none { word.value == it.value } && word.isWord() }
}

fun String.splitToWords() =
    split(' ').map { Word(it) }