import java.io.Writer
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

interface ResultWriter {
    fun write(wordCountResult: WordCounter.Result, knownWordsDictionary: Set<String>? = null)
}

class StreamResultWriter(
    private val indexWriter: IndexWriter,
    private val writer: Writer
) : ResultWriter {

    // English format must be specified so that instead of current locale separator we consistently use
    // '.' as a decimal separator.
    private val decimalFormat = DecimalFormat("#.##", DecimalFormatSymbols(Locale.ENGLISH)).apply {
        roundingMode = RoundingMode.HALF_UP
    }

    override fun write(wordCountResult: WordCounter.Result, knownWordsDictionary: Set<String>?) {
        writer.write("Number of words: ${wordCountResult.wordCount}")
        writer.write(", unique: ${wordCountResult.uniqueWords}")
        writer.write("; average word length: ${decimalFormat.format(wordCountResult.averageWordLength)} characters")
        writer.write("\n")

        wordCountResult.index?.let { indexWriter.write(it, knownWordsDictionary) }

        writer.flush()
    }
}
