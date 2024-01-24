package providers;

import java.util.Scanner;

public class DataProvider implements IDataProvider {

    public String getData(Scanner scanner){
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        return sentence;
    }

}
