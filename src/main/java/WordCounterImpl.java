import java.util.Scanner;

public class WordCounterImpl implements WordCounter {
    @Override
    public int countWords() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] tokens = line.trim().split("\\s+");

        int count = 0;

        for(String token : tokens) {
            if(containsOnlyAlphabetic(token)) {
                count++;
            }
        }
        return count;
    }

    private boolean containsOnlyAlphabetic(String token) {
        for(char c : token.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
