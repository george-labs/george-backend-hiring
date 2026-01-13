package model

private const val INDEXED_FLAG = "-index"

data class ArgumentsStore(
    val filePath: String? = null,
    val indexed: Boolean = false,
) {
    fun isFileProvided() = !filePath.isNullOrBlank()
}

fun Array<String>.toArgumentsStore(): ArgumentsStore {
    with(map { it.lowercase() }) {
        val filePath = firstOrNull() { !it.startsWith("-") }
        val indexed = contains(INDEXED_FLAG)
        return ArgumentsStore(
            filePath = filePath,
            indexed = indexed,
        )
    }
}
