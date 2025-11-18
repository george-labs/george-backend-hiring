class WordCounter {

    internal var regex: Regex = Regex("([a-zA-Z]+)")

    fun countWords(input: String) = regex.findAll(input).count()

}