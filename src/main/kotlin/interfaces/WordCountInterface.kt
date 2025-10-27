package interfaces

import model.WordCount
import java.io.File

interface WordCountInterface{
    fun collectWordCountElements(input: String):List<WordCount>
    fun parseWordFile(file: File):Set<String>
    fun collectTotalNrOfElements(result: List<WordCount>):Int
    fun collectUniqueNrOfElements(result: List<WordCount>):Int
}