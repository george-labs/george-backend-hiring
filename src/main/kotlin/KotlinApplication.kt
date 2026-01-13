fun main() {
    val wordCounterService = service.WordCounterService()
    val wordCounterController = controller.WordCounterController(wordCounterService)
    wordCounterController.start()
}