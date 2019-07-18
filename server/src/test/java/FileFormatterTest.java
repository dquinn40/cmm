import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class FileFormatterTest {


    @Test
    public void linesShorterThanEighty() throws Exception {
        List<String> wrappedLines = wrapText(readFile("article.txt"));
        List<String> validWrappedLines = readFile("valid-article.txt");

        Assert.assertEquals(validWrappedLines.size(), wrappedLines.size());

        for(int idx = 0; idx < wrappedLines.size(); idx++) {
            System.out.println(wrappedLines.get(idx));
            String actual = wrappedLines.get(idx).trim();
            String expected = validWrappedLines.get(idx).trim();
            Assert.assertTrue(String.format("expected: %s, actual: %s", expected, actual), expected.equals(actual));
        }
    }

    @Test
    public void returnIndexForLastSpace() throws Exception {
        Assert.assertEquals(5, getLastSpaceInString("wwwww w"));
    }

    private List<String> readFile(String filename) throws Exception {
        return FileUtils.readLines(
                new File(FileFormatterTest.class.getResource(filename).toURI()), Charset.defaultCharset());
    }

    private List<String> wrapText(List<String> lines) throws Exception {
        List<String> wrappedLines = new ArrayList<>();

        String overrun = "";
        for(int idx = 0; idx < lines.size(); idx++) {
            String trimmedLine = lines.get(idx).trim();
            overrun = overrun.trim();
            if(trimmedLine.length() == 0 && overrun.length() > 0) {
                while(overrun.length() > 0) {
                    if(overrun.length() > 80) {
                        int spaceIdx = overrun.substring(0, 80).lastIndexOf(" ");
                        wrappedLines.add(overrun.substring(0, spaceIdx).trim());
                        overrun = overrun.substring(spaceIdx, overrun.length());
                    } else {
                        wrappedLines.add(overrun.trim());
                        if(idx != lines.size() - 1) wrappedLines.add("");
                        overrun = "";
                    }
                }
            } else if (trimmedLine.length() == 0) {
                wrappedLines.add(trimmedLine);
            } else {
                if(overrun.length() > 0) {
                    trimmedLine = overrun.trim() + " " + trimmedLine;
                }
                if(trimmedLine.length() < 81) {
                    wrappedLines.add(trimmedLine);
                    overrun = "";
                } else {
                    int lastSpaceIdx = getLastSpaceInString(trimmedLine.substring(0, 80));
                    wrappedLines.add(trimmedLine.substring(0, lastSpaceIdx));
                    overrun = trimmedLine.substring(lastSpaceIdx, trimmedLine.length());
                }
            }
        }
        return wrappedLines;
    }

    private int getLastSpaceInString(String str) throws Exception {
       return str.lastIndexOf(" ");
    }
}
