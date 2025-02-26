package com.dusanbartos.wordcount.domain

data class WordCounterResult(
    val all: Int,
    val unique: Int,
    val averageLength: Double,
)
