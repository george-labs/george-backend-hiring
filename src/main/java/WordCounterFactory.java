public class WordCounterFactory {

    public WordCounter getWordCounter(String[] args) {
        FileReader fileReader = new FileReader();
        StopWords stopWords = new StopWords(fileReader);

        return args.length > 0 ? new WordCounterFileReader(stopWords, fileReader, args[0]) : new WordCounterConsole(stopWords);
    }
}
