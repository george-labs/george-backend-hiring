import view.ReadService;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        ReadService readService = new ReadService(new Scanner(System.in));

        System.out.println("Number of words:" + readService.getWordsCount());
    }
}
