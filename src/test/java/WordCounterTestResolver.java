public class WordCounterTestResolver implements WordCounterResolver {

    private final String sentence;

    public WordCounterTestResolver(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String resolve() {
        return sentence;
    }
}
