package dto

import java.io.Serializable

data class CounterResult (
    val count: Int,
    val unique: Int,
): Serializable