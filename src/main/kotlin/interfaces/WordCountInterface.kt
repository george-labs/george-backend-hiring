package interfaces

import model.WordCount

interface WordCountInterface{
    fun count(input: String):List<WordCount>
}