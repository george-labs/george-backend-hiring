import java.io.Writer
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

interface ResultWriter {
    fun write(result: WordCounter.Result)
}

class StreamResultWriter(
    private val writer: Writer
): ResultWriter {

    // English format must be specified so that instead of current locale separator we consistently use
    // '.' as a decimal separator.
    private val decimalFormat = DecimalFormat("#.##", DecimalFormatSymbols(Locale.ENGLISH)).apply {
        roundingMode = RoundingMode.HALF_UP
    }

    override fun write(result: WordCounter.Result) {
        writer.write("Number of words: ${result.wordCount}")
        writer.write(", unique: ${result.uniqueWords}")
        writer.write("; average word length: ${decimalFormat.format(result.averageWordLength)} characters")
        writer.write("\n")
        writer.flush()
    }
}
