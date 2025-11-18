
fun main(args: Array<String>) {
    val fileName = args.toList().firstOrNull()
    App().runApp(fileName)
}