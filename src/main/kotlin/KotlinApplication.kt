class KotlinApplication {
}

fun main(args: Array<String>) {
    println("Hello world")

    val wordCounter = WordCounter()
    println("Word count: ${wordCounter.count("word word word")}")
}