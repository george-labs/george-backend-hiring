import counter.WordCounterProcessor;
import counter.WordCounterService;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounterProcessor processor = new WordCounterProcessor(new WordCounterService());
        String input = args[0];
        //in Q-env: debug input
        String output = processor.process(input);

        //in Q-env: debug output
        System.out.println(output);
    }
}
