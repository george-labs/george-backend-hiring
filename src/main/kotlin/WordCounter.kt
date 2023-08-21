class WordCounter {
    companion object {
        fun wordCount(content: String, stopWords: List<String>): Int {
            val words = content.trim().split(" ").map { it.trim() }.filter { it.isNotEmpty() }
            val regex = """[a-zA-Z]*""".toRegex()
            var wordCount = 0
            for (word in words) {
                wordCount = if (!stopWords.contains(word) && regex.matches(word)) wordCount + 1 else wordCount
            }
            return wordCount
        }
    }
}