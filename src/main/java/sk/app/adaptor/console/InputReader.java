package sk.app.adaptor.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sk.app.domain.api.incoming.InputTextReader;

public class InputReader implements InputTextReader {

	@Override
	public String readText() throws IOException {
		String text;
		try (java.io.Reader inputStream = new InputStreamReader(System.in);
			 BufferedReader reader = new BufferedReader(inputStream)) {
			text = reader.readLine();
		}

		return text;
	}
}
