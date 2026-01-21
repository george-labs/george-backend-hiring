package reader

class CmdReader : InputReader {
    override fun readInput(): String? = readlnOrNull()
}