package interfaces

import model.WordCount
import java.io.File

interface WordCountInterface{
    fun count(input: String):List<WordCount>
    fun parseWordFile(file: File):Set<String>
}