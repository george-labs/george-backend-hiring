package at.erste.io

class ConsoleOutputWriter : OutputWriter {
    override fun write(output: String) {
        println(output)
    }
}
