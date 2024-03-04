public class JavaApplication {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        StopWords stopWords = new StopWords(fileReader);

        WordCounterResolverFactory wordCounterResolverFactory = new WordCounterResolverFactory(fileReader, args);
        WordCounter wordCounter = new WordCounterImpl(stopWords, wordCounterResolverFactory.getResolver());

        System.out.println("Number of words: " + wordCounter.count());
    }
}
