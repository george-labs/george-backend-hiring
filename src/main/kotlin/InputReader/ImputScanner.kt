package InputReader

import java.util.Scanner

class ImputScanner : InputInterface {

    companion object {
        val scanner = Scanner(System.`in`)
    }

    override fun readText() = scanner.nextLine()
}
