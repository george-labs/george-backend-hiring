package com.dusanbartos.wordcount.domain

data class WordCountAppConfig(
    val inputFilePath: String? = null,
    val printIndex: Boolean = false,
)
