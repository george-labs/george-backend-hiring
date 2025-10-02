interface InputReader {
    fun read(): String
}


class StdinInputReader : InputReader {
    override fun read(): String {
        return readlnOrNull().orEmpty()
    }
}

