package data

class Word(val value: String) {
    fun isWord() =
        value.matches("[A-Z,a-z]+".toRegex())
}