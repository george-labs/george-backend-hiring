import wordcount.InputReader;
import wordcount.OutputWriter;
import wordcount.StopWordsLoader;
import wordcount.WordCountService;

import java.util.Set;

public class JavaApplication {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final WordCountService wordCountService;

    JavaApplication(InputReader inputReader, OutputWriter outputWriter, WordCountService wordCountService) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.wordCountService = wordCountService;
    }

    public static void main(String[] args) {
        // TODO: Partial implementation of iteration3
//        List<String> sentence = new ArrayList<>();
//        if (args.length != 0) {
//            String inputFile = args[0];
//            System.out.println("Input file: " + inputFile);
//            // read from file stored in inputFile
//            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    sentence.add(line);
//                }
//            } catch (IOException e) {
//                System.err.println(String.format("Error reading %s", inputFile));
//            }
//        }
//
//        System.out.println("Test sentence: " + sentence);

        StopWordsLoader stopWordsLoader = new StopWordsLoader();
        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords.txt");

        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        WordCountService wordCountService = new WordCountService(stopWords);

        JavaApplication javaApplication = new JavaApplication(inputReader, outputWriter, wordCountService);
        javaApplication.run();
    }

    public void run() {
        String sentence = inputReader.getInput();

        outputWriter.writeOutput(wordCountService.countWords(sentence));
    }
}
