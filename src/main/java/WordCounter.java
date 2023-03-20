
public class WordCounter {

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] words = text.split(" ");
        int count = 0;
        for(String s : words) {
            if (s.matches("[A-Za-z]+")) count++;
        }
        return count;
    }
}
