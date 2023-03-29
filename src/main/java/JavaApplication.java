import java.util.Scanner;

public class JavaApplication {


  public static void main(String[] args) {
    Counter wc = new WordCounter();
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter text: ");
    System.out.println("Number of words: " + wc.getCount(scan.nextLine()));
  }

}
