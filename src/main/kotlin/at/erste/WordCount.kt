package at.erste

fun countWords(input: String): Int {
    val wordCandidates = input.split(" ")
        .filter { it.matches("([a-zA-Z]+)([.,?!]*)".toRegex()) }
    return wordCandidates.size
}
