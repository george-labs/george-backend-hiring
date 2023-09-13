package sk.app.application.port.api.incoming;

import java.io.IOException;

public interface InputTextReader {

	String readText() throws IOException;
}
