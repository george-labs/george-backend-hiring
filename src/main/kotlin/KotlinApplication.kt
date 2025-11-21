fun main(args: Array<String>) {
    val ioService = IOService(System.`in`)
    val text = ioService.getInputText(args) ?: return

    //   call service
    val service = WordService()
    val wordsCount = service.countWords(text)
    val uniqueCount = service.countUnique(text)

    //   print result
    ioService.msgln("Number of words: $wordsCount, unique: $uniqueCount")
}