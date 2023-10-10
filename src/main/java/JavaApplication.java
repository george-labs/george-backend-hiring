public class JavaApplication {

    public static void main(String[] args) {
        WordValidator validator = new EuropeanWordValidator();
        StopWordsFileReader fileReader = new StopWordsFileReader();
        WordCounter counter = new OneSpaceWordCounter(validator, fileReader);
        LineReader reader = new ConsoleLineReader();

        String s = reader.readLine();

        System.out.println(counter.countWords(s));
    }
}
