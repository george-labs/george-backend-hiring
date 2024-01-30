package application.infrastructure.input;

import application.infrastructure.exceptions.NoFileFoundException;

import java.io.*;

import static application.infrastructure.InfrastructureConstants.NO_SUCH_FILE;

class FileInput implements Input {
    private final static String SPACE = " ";
    private final String filePath;

    public FileInput(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getInput()  {
       try{
           return getDataFromFile();
       } catch (IOException e) {
           throw new NoFileFoundException(NO_SUCH_FILE);
       }
    }

    private String getDataFromFile() throws IOException {
        final File file = new File(filePath);
        final InputStream inputStream = new FileInputStream(file);
        final StringBuilder stringBuilder = new StringBuilder();

        if (inputStream == null) {
            return "";
        }

        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(SPACE);
            }
        }
        return stringBuilder.toString();
    }
}
