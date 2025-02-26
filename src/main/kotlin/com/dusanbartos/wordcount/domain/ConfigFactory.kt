package com.dusanbartos.wordcount.domain

interface ConfigFactory {
    fun create(args: Array<String>): WordCountAppConfig
}

class ConfigFactoryImpl : ConfigFactory {
    override fun create(args: Array<String>): WordCountAppConfig {
        if (args.size > 1) {
            throw InvalidConfigException("${args.size} args but expecting max 1")
        }

        return WordCountAppConfig(
            inputFilePath = args.getOrNull(0),
        )
    }
}

class InvalidConfigException(message: String) : IllegalArgumentException(message)