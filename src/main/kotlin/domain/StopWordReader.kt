package domain

import data.FileReader

class StopWordReader(
    private val fileReader: FileReader,
) {


    fun getStopWords(rawFileContent: String){
        val wordPerLine = rawFileContent.split("\n")
        // check that elements are not empty
    }

}