fun main(args: Array<String>) {
    print("Enter text:")
    val stringInput = readLine()!!
    println("You entered: $stringInput with ${countWords(stringInput)} words")
}

fun countWords(input: String): Int {
    val wordCandidates = input.split(" ")
        .filter { it.matches("([a-zA-Z]+)([.,?!]*)".toRegex()) }
    return wordCandidates.size
}

class KotlinApplication {

}
