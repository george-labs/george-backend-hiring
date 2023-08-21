class KotlinApplication {
    companion object {
        fun wordCount(content: String): Int {
            val words = content.trim().split(" ").map { it.trim() }.filter { it.isNotEmpty() }
            val regex = """[a-zA-Z]*""".toRegex()
            var wordCount = 0
            for (word in words) {
                wordCount = if (regex.matches(word)) wordCount + 1 else wordCount
            }
            return wordCount
        }
    }
}

fun main() {
    print("Enter text: ")
    val input = readln()
    val wordCount = KotlinApplication.wordCount(input)
    println("Number of words: $wordCount")
}