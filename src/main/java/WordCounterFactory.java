public class WordCounterFactory {

    public WordCounter getWordCounter(String[] args) {
        FileReader fileReader = new FileReader();
        StopWords stopWords = new StopWords(fileReader);

        WordCounterResolver wordCounterResolver = args.length > 0 ? new WordCounterFileResolver(fileReader, args) : new WordCounterConsoleResolver();

        return new WordCounterImpl(stopWords, wordCounterResolver);
    }
}
