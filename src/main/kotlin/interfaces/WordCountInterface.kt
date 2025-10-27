package interfaces

import model.WordCount
import java.io.File

interface WordCountInterface{
    fun collectWordCountElements(input: String):List<WordCount>
    fun parseWordFile(file: File):Set<String>
    fun totalCount(result: List<WordCount>):Int
    fun uniqueCount(result: List<WordCount>):Int
    fun takeAverage(result: List<WordCount>, totalCount: Int): Double
}