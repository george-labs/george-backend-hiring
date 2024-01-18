import java.io.Writer

interface ResultWriter {
    fun write(result: WordCounter.Result)
}

class StreamResultWriter(
    private val writer: Writer
): ResultWriter {

    override fun write(result: WordCounter.Result) {
        writer.write("Number of words: ${result.wordCount}, unique: ${result.uniqueWords}\n")
    }
}
