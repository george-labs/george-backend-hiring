package input

import java.io.FileInputStream

class FileBasedReadInputStrategy(private val filepath: String): ReadInputStrategy {
    override fun readInput(): String {
        return FileInputStream(filepath).bufferedReader().readText()
    }
}