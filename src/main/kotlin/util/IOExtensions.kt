package util

import data.WordWrapper

fun readFromPrompt(): List<WordWrapper> {
    print("Enter text: ")
    return readln().splitToWords()
}