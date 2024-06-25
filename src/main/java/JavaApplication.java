import java.util.List;

public class JavaApplication {

    public static void main(String[] args) {


        long result;
        if (args.length == 1) {
            var textFile = args[0];
            List<String> inputLines = new FileLoader().loadFile(textFile);
            result = new WordCounter(new FileLoader()).countNotBlackListedWords(WordUtils.splitWords(inputLines));
            //process text file
        } else if (args.length == 0) {
            System.out.print("Enter text: ");
            var input = new InputProcessor(System.in).readInput();
            result = new WordCounter(new FileLoader()).countNotBlackListedWords(input);
        } else {
            throw new UnsupportedOperationException();
        }

        System.out.print("Number of words: " + result);
    }


}
