class WordCounter {
    companion object {
        fun wordCount(content: String, stopWords: List<String>): Pair<Int, Int> {
            val words = content.trim().split(" ", ".").map {
                it.trim().lowercase()
            }.filter {
                it.isNotEmpty()
            }

            val regex = """[a-z-A-Z]*""".toRegex()
            var wordCount = 0
            val uniqueWordsSet: MutableSet<String> = mutableSetOf()
            for (word in words) {
                if (!stopWords.contains(word) && regex.matches(word)) {
                    wordCount++
                    uniqueWordsSet.add(word)
                }
            }
            return Pair(wordCount, uniqueWordsSet.size)
        }
    }
}