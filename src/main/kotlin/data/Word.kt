package data

class Word(private val value: String) {
    fun isWord() =
        value.matches("[A-Z,a-z]+".toRegex())


    fun isWord(stopWord: List<Word>) =
        stopWord.filterNot { it.value == value }.isEmpty() && isWord()
}