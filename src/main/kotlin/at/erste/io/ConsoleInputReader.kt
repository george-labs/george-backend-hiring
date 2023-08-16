package at.erste.io

class ConsoleInputReader : InputReader {
    override fun readUserInput(prompt: String?): String {
        prompt?.let { print(it) }
        return readln()
    }
}
