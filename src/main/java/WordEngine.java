import java.util.HashMap;
import java.util.Scanner;

public class WordEngine {
    HashMap map = new HashMap();


    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    //65-90 97-122(toLowercase?)
    public boolean isLetter (char ch){
        return (ch > 64 && ch < 91) || (ch > 96 && ch < 123);
    }
}
