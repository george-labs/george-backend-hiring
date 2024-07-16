import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {
	@Test
	void getInput() throws Exception {
		final InputStream stream = new ByteArrayInputStream("Das ist ein Test\n".getBytes());
		Assertions.assertEquals("Mary had\na little\nlamb\n", JavaApplication.getInput(new String[] {"src/test/resources/mytext.txt"}, stream));
		//System.setIn(new ByteArrayInputStream("Das ist ein Test\n".getBytes()));
		//Assertions.assertNotNull(System.in);
		final String[] args = new String[0];
		Assertions.assertEquals("Das ist ein Test", JavaApplication.getInput(args, stream));
	}
}
