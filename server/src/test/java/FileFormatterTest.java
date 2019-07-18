import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class FileFormatterTest {


    @Test
    public void linesShorterThanEighty() throws Exception {
        List<String> wrappedLines = FileFormatter.wrapText(readFile("article.txt"));
        List<String> validWrappedLines = readFile("valid-article.txt");

        Assert.assertEquals(validWrappedLines.size(), wrappedLines.size());

        for(int idx = 0; idx < wrappedLines.size(); idx++) {
            System.out.println(wrappedLines.get(idx));
            String actual = wrappedLines.get(idx).trim();
            String expected = validWrappedLines.get(idx).trim();
            Assert.assertTrue(String.format("expected: %s, actual: %s", expected, actual), expected.equals(actual));
        }
    }

    private List<String> readFile(String filename) throws Exception {
        return FileUtils.readLines(
                new File(FileFormatterTest.class.getResource(filename).toURI()), Charset.defaultCharset());
    }
}
