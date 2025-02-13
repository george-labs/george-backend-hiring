package mock

import abstract.StopWordsLoader

class MockedStopWordContext : StopWordsLoader {
    override fun getStopWords(): Set<String> {
        return emptySet()
    }
}