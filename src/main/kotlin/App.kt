class App() {
    val consoleReader = Reader {
        readln()
    }

    val consoleWriter = Writer { output ->
        print(output)
    }


    fun mainLoop() {
        val wordCounter = WordCounter()
        consoleWriter.write("Enter text: ")
        val input = consoleReader.read()
        consoleWriter.write("Number of words: ${wordCounter.countWords(input)}")
    }
}