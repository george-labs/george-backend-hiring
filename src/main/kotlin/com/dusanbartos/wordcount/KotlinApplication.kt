@file:JvmName("KotlinApplication")
package com.dusanbartos.wordcount

import com.dusanbartos.wordcount.data.PathFileReader
import com.dusanbartos.wordcount.data.ResourceStopWordReader
import com.dusanbartos.wordcount.data.SystemInReader
import com.dusanbartos.wordcount.data.SystemOutWriter
import com.dusanbartos.wordcount.domain.ConfigFactoryImpl
import com.dusanbartos.wordcount.domain.InvalidConfigException
import com.dusanbartos.wordcount.domain.WordCountApp
import com.dusanbartos.wordcount.domain.WordCounter

fun main(args: Array<String>) {
    try {
        WordCountApp(
            reader = SystemInReader(),
            writer = SystemOutWriter(),
            counter = WordCounter(),
            stopWordReader = ResourceStopWordReader(),
            inputFileReader = PathFileReader(),
            configFactory = ConfigFactoryImpl(),
        ).run(args)
    } catch (e: InvalidConfigException) {
        println("Unexpected arguments. Allowed arguments:\n" +
                "\tfile.txt - text input to process")
    }
}