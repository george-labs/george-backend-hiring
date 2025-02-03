package data

class Word(private val value: String) {
    fun isWord() =
        value.matches("[A-Z,a-z]+".toRegex())
}