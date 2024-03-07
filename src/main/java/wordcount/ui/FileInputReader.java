package wordcount.ui;

import java.util.List;
import java.util.stream.Collectors;

import wordcount.io.FileReader;

public class FileInputReader implements UserInputReader {

	private String fileName;
	
	@Override
	public String readUserInput() {
		List<String> lines = FileReader.readLines(fileName);		
	    return lines.stream().collect(Collectors.joining(" "));		
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
