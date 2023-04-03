object WordCounter {

    fun countWords(input: String): Int = input.split(" ", "\n").count { it.matches(Regex("[a-zA-Z]+")) }

}
