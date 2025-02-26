package com.dusanbartos.wordcount.data

class MockedReader : Reader {

    private var data: String = ""

    override fun read(): String = data

    fun setup(data: String) {
        this.data = data
    }
}