import controller.WordCounterController
import model.toArgumentsStore

fun main(args: Array<String>) {
    val arguments = args.toArgumentsStore()
    WordCounterController(arguments).start()
}