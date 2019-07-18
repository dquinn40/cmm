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

    /*
        This test cast would be used to refactor the performance of the algorithm. Its not written very efficiently, yet.
            Would just need to know what the performance requirement is first - if there was one.
     */
    @Test(timeout = 50L)
    public void algorithmMeetSla() throws Exception {
        FileFormatter.wrapText(readFile("article.txt"));
    }

    private List<String> readFile(String filename) throws Exception {
        return FileUtils.readLines(
                new File(FileFormatterTest.class.getResource(filename).toURI()), Charset.defaultCharset());
    }
}
