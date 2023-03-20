public interface IWordCounter {

    int countWords(String text);

    void loadExcludedWords(String fileName);

}
