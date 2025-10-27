package service

import interfaces.InputHandlerInterface
import java.io.File

class InputHandlerService: InputHandlerInterface {
    override fun inputValidation(inputArguments: Array<String>): String {
        val input = if (inputArguments.isNotEmpty()) {
            val inputFile = File( inputArguments[0])
            if (inputFile.exists()) inputFile.readText()
            else {
                throw Error("File was not found:$inputFile")
            }
        } else {
            println("Enter text:")
            readlnOrNull() ?: ""
        }
        return input
    }


}