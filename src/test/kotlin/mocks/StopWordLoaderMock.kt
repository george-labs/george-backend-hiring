package mocks

import stopWorldLoader.StopWordLoader

class StopWordLoaderMock(val stopWords: Set<String>): StopWordLoader {

    override fun loadFromResources(): Set<String> {
        return stopWords
    }
}