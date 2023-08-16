package at.erste.io

class TestOutputWriter : OutputWriter {
    var output: String? = null
    override fun write(output: String) {
        this.output = output
    }
}
