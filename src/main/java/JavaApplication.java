import service.ValidationService;
import service.ValidationServiceImpl;
import service.WordAnalysisService;
import service.WordAnalysisServiceImpl;

public class JavaApplication {
    public static void main(String[] args) {
        ValidationService validationService = new ValidationServiceImpl();
        WordAnalysisService wordAnalysisService = new WordAnalysisServiceImpl();
        String inputString = args[0];

        try {
            validationService.isValid(inputString);
        }



    }
}
