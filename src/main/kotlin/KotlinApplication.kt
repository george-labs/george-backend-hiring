class KotlinApplication {
    fun scan() {
        val imputScanner = ImputScanner()
        val simpleCounter = SimpleCounter()
        print("Enter text: ")
        val count = simpleCounter.count(imputScanner.readText())
        println("Number of words: $count")
    }
}

fun main() {
    val kotlinApplication = KotlinApplication()
    kotlinApplication.scan()
}
