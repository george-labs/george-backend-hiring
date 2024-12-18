package stopWorldLoader

interface StopWordLoader {

    fun loadFromResources(): Set<String>
}