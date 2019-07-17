import org.junit.Test;

public class FileFormatterTest {

    @Test
    public void readFileUsingScanner() throws Exception {
        FileFormatter.readUsingScanner("format-me.txt");
    }

    @Test
    public void readFileUsingFileUtils() throws Exception {
        FileFormatter.readUsingFileUtils("format-me.txt");
    }
}
