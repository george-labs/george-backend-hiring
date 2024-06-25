import java.util.List;

public class JavaApplication {

    public static void main(String[] args) {


        long totalCount;
        long distinctCount;
        if (args.length == 1) {
            var textFile = args[0];
            List<String> inputLines = new FileLoader().loadFile(textFile);
            totalCount = new WordCounter(new FileLoader()).countNotBlackListedWords(WordUtils.splitWords(inputLines), false);
            distinctCount = new WordCounter(new FileLoader()).countNotBlackListedWords(WordUtils.splitWords(inputLines), true);
            //process text file
        } else if (args.length == 0) {
            System.out.print("Enter text: ");
            var input = new InputProcessor(System.in).readInput();
            totalCount = new WordCounter(new FileLoader()).countNotBlackListedWords(input, false);
            distinctCount = new WordCounter(new FileLoader()).countNotBlackListedWords(input, true);
        } else {
            throw new UnsupportedOperationException();
        }

        System.out.print("Number of words: " + totalCount + " unique: " + distinctCount);
    }


}
