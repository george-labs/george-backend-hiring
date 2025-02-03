fun main() {
    val words = readln().split(' ')
    val wordCount = words.count { it.matches("[A-Z,a-z]+".toRegex()) }
    println("Number of words: $wordCount")
}