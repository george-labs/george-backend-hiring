package model

private const val INDEXED_FLAG = "-index"
private const val DICTIONARY_FLAG = "-dictionary"

data class ArgumentsStore(
    val filePath: String? = null,
    val indexed: Boolean = false,
    val dictionaryFilePath: String? = null,
) {
    fun isFileProvided() = !filePath.isNullOrBlank()
}

fun Array<String>.toArgumentsStore(): ArgumentsStore {
    with(map { it.lowercase() }) {
        val filePath = firstOrNull() { !it.startsWith("-") }
        val indexed = contains(INDEXED_FLAG)
        val dictionaryFilePath =
            if (!indexed) null else firstOrNull { it.startsWith("$DICTIONARY_FLAG=") }?.substringAfter("=")
        return ArgumentsStore(
            filePath = filePath,
            indexed = indexed,
            dictionaryFilePath = dictionaryFilePath,
        )
    }
}
