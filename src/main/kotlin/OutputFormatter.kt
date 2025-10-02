import java.text.NumberFormat
import java.util.Locale

class OutputFormatter {
    private val numberFormatter = NumberFormat.getNumberInstance(Locale.US).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    fun writeToStdOut(words: Words) {
        print("Number of words: ${words.filteredCount}, ")
        print("unique: ${words.uniqueFilteredCount};")
        print("average word length: ${numberFormatter.format(words.avgWordLength)}")
    }
}