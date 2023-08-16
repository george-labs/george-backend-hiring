package at.erste.io

class TestInputReader : InputReader {
    var input: String? = null
    override fun readUserInput(prompt: String?): String {
        return input ?: ""
    }
}
