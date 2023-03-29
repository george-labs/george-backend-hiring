import java.util.Scanner;

public class JavaApplication {

  private static final String SPACE = " ";

  public static void main(String[] args) {
    JavaApplication javaApplication = new JavaApplication();
    Scanner scan = new Scanner(System.in);
    System.out.printf("Enter text: ");
    System.out.println("Number of words: " + javaApplication.wordCount(scan.nextLine()));
  }

  public int wordCount(String input) {
    if (input == null || input.isBlank())
      return 0;

    int wordCount = 0;

    input = input.trim().replaceAll(" +", " ");

    if (input.isBlank()) {
      return wordCount;
    }

    return input.split(SPACE).length;
  }

}
