fun main(args: Array<String>) {
    print("Enter text: ")
    val words = readln().split(" ")
    print("Number of words: ")
    println(words.filter { it.matches("[A-Za-z]+".toRegex()) }.size)
}