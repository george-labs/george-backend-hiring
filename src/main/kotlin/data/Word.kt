package data

class Word(val value: String) {
    fun isWord() =
        value.matches("[A-Za-z-]+".toRegex())
}