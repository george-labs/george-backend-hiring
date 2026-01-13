package controller

class WordCounterController(
    private val wordCounterService: service.WordCounterService,
) {
    fun start() {
        print("Enter text: ")
        val inputText = readln()
        val wordCount = wordCounterService.countWords(inputText)
        println("Number of words: $wordCount")
    }
}