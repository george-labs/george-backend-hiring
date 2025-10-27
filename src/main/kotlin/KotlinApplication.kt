import interfaces.InputHandlerInterface
import interfaces.WordCountInterface
import service.InputHandlerService
import service.WordCountService
import java.io.File



fun main(args: Array<String>) {
    try {
        val file = File("src/main/resources/stopwords.txt")
        val counter: WordCountInterface = WordCountService(file)

        val inputHandlerService: InputHandlerInterface = InputHandlerService()
        val inputInformation = inputHandlerService.inputValidation(args)
        val result = counter.collectWordCountElements(inputInformation)

        val total = counter.collectTotalNrOfElements(result)
        val uniques = counter.collectUniqueNrOfElements(result)
        println("Number of words: $total, unique: $uniques")
    } catch (e: Error) {
        println(e.message)
    }

}
    