package sk.app.adaptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sk.app.adaptor.api.Reader;

public class InputReader implements Reader {

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
