fun countWords(text: String): Int {
    return Regex("[A-Za-z]+").findAll(text).count()
}