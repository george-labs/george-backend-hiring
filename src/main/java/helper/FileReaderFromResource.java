package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class FileReaderFromResource {
	
	public static Optional<String> getFileContent(String fileName) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(fileName);
		try {
			String fileContent = readFromInputStream(is);
			return Optional.of(fileContent);
			
		} catch (IOException e) {
			return Optional.empty();
		} 
	}
	
	private static String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append(" ");
			}
		}
		
		return resultStringBuilder.toString();
	}

}
