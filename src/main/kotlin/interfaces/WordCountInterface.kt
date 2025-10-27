package interfaces

import model.WordCount
import java.io.File

interface WordCountInterface{
    fun count(input: String):List<WordCount>
    fun parseStopWordFile(file: File):Set<String>
}