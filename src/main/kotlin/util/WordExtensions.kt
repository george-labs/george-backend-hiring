package util

import data.WordWrapper

fun WordWrapper.isAcceptedWord() =
    value.matches("[A-Za-z-]+".toRegex())