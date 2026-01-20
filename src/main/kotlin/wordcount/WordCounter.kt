package wordcount

class WordCounter {

    fun countWords(input: String?): Int {
        if (input == null) return 0

        return input.trim().split(Regex("[^A-Za-z]+")).filter { it.isNotBlank() }.size
    }
}