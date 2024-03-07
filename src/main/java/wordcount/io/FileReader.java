package wordcount.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileReader {	

	public static List<String> readLines(String filename) {
		Path path;
		List<String> lines;
		try {
			try {
				// try to load file from classloader
				URI uri = FileReader.class.getClassLoader().getResource(filename).toURI();
				path = Paths.get(uri);
			} catch ( NullPointerException e ) {
				// try to load file from absolute/relative path
				path = Paths.get(filename);				
			}
			
			lines = Files.readAllLines(path);
		} catch (URISyntaxException | IOException e ) {
			// no need to log or rethrow the exception, this is a compile-time error
			lines = new ArrayList<>();
		}
		return lines;
	}

	public static Set<String> readUniqueLines(String filename) {
		return new HashSet<>(readLines(filename));
	}

}
