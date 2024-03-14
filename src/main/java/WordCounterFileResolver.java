public class WordCounterFileResolver implements WordCounterResolver {

    private final FileReader fileReader;
    private final String[] args;

    public WordCounterFileResolver(FileReader fileReader, String[] args) {
        this.fileReader = fileReader;
        this.args = args;
    }

    @Override
    public String resolve() {
        return fileReader.readString(args[0]);
    }
}
