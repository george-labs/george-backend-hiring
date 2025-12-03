import dto.ResultOutput;
import exception.InvalidInputException;
import service.*;



public class JavaApplication {
    public static void main(String[] args) {
        ValidationService validationService = new ValidationServiceImpl();
        WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl();
        String argument = args.length > 0 ? args[0] : null;
        UserInputService userInputService = getUserInputService(argument);


        String inputString = userInputService.getUserInput();


        try {
            validationService.validate(inputString);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ResultOutput result = wordAnalysisService.analyze(inputString);

        System.out.println("Number of words: " + result.getWordCount());
    }

    public static UserInputService getUserInputService(String stringArgument) {
        if (stringArgument == null) {
            return new CommandService();
        } else {
            return new FileInputService(stringArgument);
        }
    }
}
