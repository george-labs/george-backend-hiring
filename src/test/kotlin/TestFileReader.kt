class TestFileReader(private val lines: List<String>) : IFileReader {
    override fun readLines(): List<String> = lines
}
