package com.erste.interview.logic

import java.math.BigDecimal

data class CountResult(
    val wordCount: Int,
    val uniqueCount: Int,
    val avgLength: BigDecimal,
)