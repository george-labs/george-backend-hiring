package service;

import java.util.List;

public interface WordAnalysisService {

    String sanitizeString(String inputString);

    List<String> getWords(String inputString);

}
