package service;

public class WordCountService implements ICountService {
    @Override
    public int countWordsInString(String string, String delimiter) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        return string.split(delimiter).length;
    }
}
