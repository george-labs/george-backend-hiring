import java.io.FileNotFoundException
import java.io.InputStream

interface StopWordsReader {
    fun readStopWords(): Set<String>
}

class ClasspathStopWordsReader : StopWordsReader {

    private val classLoader = this::class.java.classLoader

    override fun readStopWords(): Set<String> {
        return try {
            // We need to load the file as stream, because when using certain bundling methods (e.g., .jar)
            // files from resources cannot be treated as normal file system files and need to be read
            // using streams.
            classLoader.getResourceAsStream("stopwords.txt").use { stopWordsStream ->
                // As part of the requirements, if the stopwords file is not present for some reason
                // (even though it should be bundled with application), we should ignore it.
                val stream = stopWordsStream ?: InputStream.nullInputStream()
                stream.bufferedReader().readLines().toSet()
            }

        } catch (e: FileNotFoundException) {
            // This file should be bundled during build time, so we don't expect customers to ever see this.
            // The requirements state that if no stopwords.txt file is found, we should continue without it.
            // (This requirement should also be satisfied by us passing in empty stream)
            System.err.println("Expected stopwords.txt file to be present and contain line delimited list of stop words.")
            emptySet()
        }
    }

}
