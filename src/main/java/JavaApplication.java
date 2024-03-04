public class JavaApplication {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        StopWords stopWords = new StopWords(fileReader);

        WordCounterResolverFactory wordCounterResolverFactory = new WordCounterResolverFactory(fileReader, args);
        WordCounter wordCounter = new WordCounterImpl(stopWords, wordCounterResolverFactory.getResolver());

        WordCounterResult result = wordCounter.getResult();
        System.out.printf("Number of words: %d, unique: %d", result.getCount(), result.getUnique());
    }
}
