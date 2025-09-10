private val wordRegex = """[A-Za-z]+(-[A-Za-z]+)?""".toRegex()

fun parseInput(input: String): List<String> {
    return input.split("\\s+".toRegex()).filter { it.matches(wordRegex) }
}