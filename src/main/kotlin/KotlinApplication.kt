fun main() {
    val consoleReader = Reader {
        readln()
    }

    val consoleWriter = Writer { output ->
        print(output)
    }

    App().mainLoop(consoleReader, consoleWriter)
}