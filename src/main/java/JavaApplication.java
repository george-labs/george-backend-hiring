import dto.ResultOutput;
import exception.InvalidInputException;
import service.ValidationService;
import service.ValidationServiceImpl;
import service.WordAnalysisService;
import service.WordAnalysisServiceImpl;

import java.util.Scanner;


public class JavaApplication {
    public static void main(String[] args) {
        ValidationService validationService = new ValidationServiceImpl();
        WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        String inputString = scanner.nextLine();

        try {
            validationService.validate(inputString);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ResultOutput result = wordAnalysisService.analyze(inputString);

        System.out.println("Number of words: " + result.getWordCount());
    }
}
