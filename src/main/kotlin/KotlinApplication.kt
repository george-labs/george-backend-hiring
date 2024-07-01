class KotlinApplication {

}

fun main(args: Array<String>) {
    scan()
}

fun scan(): String {
    val imputScanner = ImputScanner()
    val simpleCounter = SimpleCounter()
    return simpleCounter.count("")
}