object WordCounter {

    fun countWords(line: String) : Int {
        if (line.isEmpty()) {
            return 0
        }
        val wordCounter = line.split("\\s+".toRegex()).count()

        return wordCounter
    }
}