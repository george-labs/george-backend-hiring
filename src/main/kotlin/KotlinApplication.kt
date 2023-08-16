import at.erste.countWords

fun main(args: Array<String>) {
    print("Enter text:")
    val stringInput = readLine()!!
    println("You entered: $stringInput with ${countWords(stringInput)} words")
}

class KotlinApplication
