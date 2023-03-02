/**
 * Returns the number of words in the text,
 * words hve to be separated by one or more " " (space) characters,
 * a sequence of characters containing anything else except a-z and A-Z is not a word and thus ignored
 */
fun countWords(text: String) =
    text.split(Regex(" +"))
            .filter { it.matches(Regex("[A-Za-z]+")) }
            .count()

fun main() {
    print("Enter text: ")
    val count = countWords(readln())
    println("Number of words: $count")
}