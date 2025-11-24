import counter.processor.ProcessorType;
import counter.processor.WordCounterProcessor;
import counter.processor.WordCounterProcessorFactory;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        final WordCounterProcessor processor;
        String input;
        String output;

        if (args.length == 0) {
            System.out.println("Enter text");
            Scanner scanner = new Scanner(System.in);
            //read from user input
            input = scanner.nextLine();
            processor = WordCounterProcessorFactory.createProcessor(ProcessorType.STRING);
        } else {
            //read first parameter as file
            input = args[0];
            processor = WordCounterProcessorFactory.createProcessor(ProcessorType.FILE);
        }
        output = processor.process(input);

        //in Q-env: debug output
        System.out.println(output);
    }
}
