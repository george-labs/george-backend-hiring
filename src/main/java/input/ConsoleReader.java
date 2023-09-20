package input;

import java.io.*;

public class ConsoleReader implements InputReader {

    @Override
    public String readLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text: ");
        return bufferedReader.readLine();
    }

}
