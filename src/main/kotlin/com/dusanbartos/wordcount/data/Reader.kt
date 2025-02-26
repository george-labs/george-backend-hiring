package com.dusanbartos.wordcount.data

interface Reader {
    fun read(): String
}

class SystemInReader : Reader {
    override fun read(): String = readln()
}