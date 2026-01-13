package model

data class ArgumentsStore(
    val filePath: String? = null,
) {
    fun isFileProvided(): Boolean = !filePath.isNullOrBlank()
}

fun Array<String>.toArgumentsStore(): ArgumentsStore {
    val filePath = getOrNull(0)
    return ArgumentsStore(
        filePath = filePath,
    )
}
