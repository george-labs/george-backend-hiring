class App() {
    fun mainLoop(reader: Reader, writer: Writer) {
        val wordCounter = WordCounter()
        writer.write("Enter text: ")
        val input = reader.read()
        writer.write("Number of words: ${wordCounter.countWords(input)}")
    }
}