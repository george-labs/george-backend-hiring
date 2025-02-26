package com.dusanbartos.wordcount.data

interface Writer {
    fun print(message: String)
    fun println(message: String)
}

class SystemOutWriter : Writer {
    override fun print(message: String) = kotlin.io.print(message)
    override fun println(message: String) = kotlin.io.println(message)
}