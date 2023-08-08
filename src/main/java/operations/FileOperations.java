package operations;

import java.io.*;

public class FileOperations
{
    public static String readFromFile(String filePath, String separator){
        File file = new File(filePath);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File Path");
        }
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append(separator);
            }
        }
        catch (IOException ioException)
        {
            System.out.println("Invalid File");
        }
        return resultStringBuilder.toString();
    }
}
