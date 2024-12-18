package mocks

import inputReader.InputReader

class InputReaderMock(val inputText: String): InputReader {

    override fun read(): String {
        return inputText
    }
}