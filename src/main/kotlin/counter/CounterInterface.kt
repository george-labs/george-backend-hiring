package counter

import dto.CounterResult

interface CounterInterface {
    fun count(input: String): CounterResult
}
