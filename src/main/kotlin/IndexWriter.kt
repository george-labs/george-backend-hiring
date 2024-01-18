import java.io.Writer

interface IndexWriter {
    fun write(index: List<String>, knownWordsDictionary: Set<String>? = null)
}

class StreamIndexWriter(
    private val writer: Writer
) : IndexWriter {

    override fun write(index: List<String>, knownWordsDictionary: Set<String>?) {
        writeIndexHeader(knownWordsDictionary, index)
        writeIndexEntries(index, knownWordsDictionary)
    }

    private fun writeIndexHeader(knownWordsDictionary: Set<String>?, index: List<String>) {
        writer.write("Index")

        knownWordsDictionary?.let { dictionary ->
            val unknownWordCount = index.count { !dictionary.contains(it) }
            writer.write(" (unknown: $unknownWordCount)")
        }

        writer.write(":\n")
    }

    private fun writeIndexEntries(index: List<String>, knownWordsDictionary: Set<String>?) {
        index.forEach { word ->
            writer.write(word)

            knownWordsDictionary?.let {
                if (!it.contains(word)) {
                    writer.write("*")
                }
            }

            writer.write("\n")
        }
    }

}
