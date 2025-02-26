package com.dusanbartos.wordcount.domain

interface ConfigFactory {
    fun create(args: Array<String>): WordCountAppConfig
}

class ConfigFactoryImpl : ConfigFactory {
    override fun create(args: Array<String>): WordCountAppConfig {
        var doPrintIndex = false
        var filePath: String? = null

        args.forEach { arg ->
            when {
                arg == "-index" -> {
                    doPrintIndex = true
                }
                else -> {
                    // if there was already one pass which set the filePath
                    // further parameters are invalidating the config
                    if (filePath != null) {
                        throw InvalidConfigException("Unexpected parameter.")
                    }
                    filePath = arg
                }
            }
        }


        return WordCountAppConfig(
            inputFilePath = filePath,
            printIndex = doPrintIndex,
        )
    }
}

class InvalidConfigException(message: String) : IllegalArgumentException(message)