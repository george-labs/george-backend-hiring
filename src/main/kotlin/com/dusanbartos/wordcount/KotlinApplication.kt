@file:JvmName("KotlinApplication")
package com.dusanbartos.wordcount

import com.dusanbartos.wordcount.data.ResourceStopWordReader
import com.dusanbartos.wordcount.data.SystemInReader
import com.dusanbartos.wordcount.data.SystemOutWriter
import com.dusanbartos.wordcount.domain.ConfigFactoryImpl
import com.dusanbartos.wordcount.domain.WordCountApp
import com.dusanbartos.wordcount.domain.WordCounter

@Suppress("UNUSED_PARAMETER")
fun main(args: Array<String>) {
    val config = ConfigFactoryImpl().create(args)

    WordCountApp(
        reader = SystemInReader(),
        writer = SystemOutWriter(),
        counter = WordCounter(),
        stopWordReader = ResourceStopWordReader(),
    ).run(config)
}