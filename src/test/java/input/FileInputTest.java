package input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileInputTest {

    @Test
    public void FileNotFound(){
        var test_path = "does_not_exist";
        Assertions.assertThrows(IOException.class, () -> new FileInput(test_path));
    }

    @Test
    public void FileNoPermission(){
        //TODO: Don't know how without mocking (Unix and Windows permissions are different)
    }

    @Test
    public void FileEmpty() throws IOException{
        var test_path = "src/test/resources/empty.txt";
        var expected = "";
        var fileInput = new FileInput(test_path);
        Assertions.assertEquals(expected, fileInput.getString());
    }

    @Test
    public void FileMultiline() throws IOException{
        var test_path = "src/test/resources/multiline.txt";
        var expected = "fooBar fizzBuzz";
        var fileInput = new FileInput(test_path);
        Assertions.assertEquals(expected, fileInput.getString());
    }

}
