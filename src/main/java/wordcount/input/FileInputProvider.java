package wordcount.input;

import java.util.Optional;

import helper.FileReaderFromResource;

public class FileInputProvider implements InputProvider {
	
	private String fileName;
	
	public FileInputProvider(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getInput() {

		Optional<String> fileContent = FileReaderFromResource
				.getFileContent(fileName);
		
		if (fileContent.isPresent()) {
			return fileContent.get();
		}
		
		return emptyString();
	}
	
	private String emptyString() {
		return "";
	}

}
