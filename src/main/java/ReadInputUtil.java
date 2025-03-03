import java.util.Scanner;

public class ReadInputUtil {

    public String readInputLine(String[] args, FileReader fileReader) {
        Scanner sc = new Scanner(System.in);
        String line;
        if (args != null && args.length > 0 && args[0] != null) {
            line = fileReader.getContent(args[0]);
        } else {
            System.out.print("Enter text: ");
            line = sc.nextLine();
        }
        return line;
    }
}
