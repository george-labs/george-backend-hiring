package sk.app.adaptor.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sk.app.domain.api.incoming.InputTextReader;

public class ConsoleInputReader implements InputTextReader {

	@Override
	public String readText() throws IOException {
		System.out.print("Enter text: ");
		String text;
		try (java.io.Reader inputStream = new InputStreamReader(System.in);
			 BufferedReader reader = new BufferedReader(inputStream)) {
			text = reader.readLine();
		}

		return text;
	}
}
