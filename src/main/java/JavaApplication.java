import dto.ResultOutput;
import exception.InvalidInputException;
import service.*;

public class JavaApplication {

    public static void main(String[] args) {
        String stopWordPath = "stopwords.txt";
        ValidationService validationService = new ValidationServiceImpl();
        WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl(new StopWordServiceImpl(stopWordPath));
        String argument = args.length > 0 ? args[0] : null;
        UserInputService userInputService = UserInputServiceFactory.create(argument);

        String inputString = userInputService.getUserInput();

        try {
            validationService.validate(inputString);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ResultOutput result = wordAnalysisService.analyze(inputString);
        System.out.printf("Number of words: %s, unique: %s", result.getWordCount(), result.getUniqueCount());
    }
}
