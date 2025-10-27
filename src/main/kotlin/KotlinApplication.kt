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

        val total = counter.totalCount(result)
        val uniques = counter.uniqueCount(result)
        val averageLength = counter.takeAverage(result,total)
        val averageValue ="%.2f".format( averageLength).toDouble()

        println("Number of words: $total, unique: $uniques, average word length: $averageValue")
    } catch (e: Error) {
        println(e.message)
    }

}
    