public class WordCounterResolverFactory {

    private final FileReader fileReader;
    private final String[] args;

    public WordCounterResolverFactory(FileReader fileReader, String[] args) {
        this.fileReader = fileReader;
        this.args = args;
    }

    public WordCounterResolver getResolver() {
        return args.length > 0 ? new WordCounterFileResolver(fileReader, args) : new WordCounterConsoleResolver();
    }
}
