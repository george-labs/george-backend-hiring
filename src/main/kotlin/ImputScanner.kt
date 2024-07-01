import java.util.Scanner

class ImputScanner {

    companion object {
        val scanner = Scanner(System.`in`)
    }

    fun readText() = scanner.nextLine()
}
