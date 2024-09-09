package iteration1

class WordCounter {


    fun countWords(sentence: String): Int {
        val regex = "\\b[a-zA-Z]+\\b".toRegex()
        val matches = regex.findAll(sentence)

        return matches.count()
    }
}