package com.dusanbartos.wordcount.domain

interface ConfigFactory {
    fun create(args: Array<String>): WordCountAppConfig
}

class ConfigFactoryImpl : ConfigFactory {
    override fun create(args: Array<String>): WordCountAppConfig {
        if (args.size > 1) {
            throw IllegalArgumentException("Unexpected arguments. Allowed arguments:\n" +
                    "\tfile.txt - text input to process")
        }

        TODO("Not yet implemented")
    }
}