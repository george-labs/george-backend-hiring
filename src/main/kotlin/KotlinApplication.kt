fun main() {
    val stopWordsResourceName = "stopwords.txt"
    val stopWordLoader = StopWordLoader()
    val stopWords = stopWordLoader.loadFromResources(stopWordsResourceName)

    print("Enter text: ")
    val userInput = readln()
    println("Number of words: ${WordCounter(stopWords).count(userInput)}")
}