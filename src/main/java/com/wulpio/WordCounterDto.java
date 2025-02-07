package com.wulpio;

public record WordCounterDto(
        int wordCount,
        int uniqueWordCount,
        double averageWordLength
) {
}
