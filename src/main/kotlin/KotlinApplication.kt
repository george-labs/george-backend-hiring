fun main(){

    print("Enter text:")
    val wordCounter = WordCounter(StopWordsReader())
    val stdinInputReader = StdinInputReader()
    val input = stdinInputReader.read()
    val count = wordCounter.count(input)

    println("Number of words: $count")
}