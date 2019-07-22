import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TextFormatterTest {

    @Test
    public void multipleParagraphsConvertedToSeperateStrings() {
        String text = "Here is the\nfirst paragraph.\n\nHere\n is the second\n paragraph\n\nAnd here is the third";
        List<String> paragraphs = TextFormatter.tokenizeParagraphs(text);
        Assert.assertEquals(3, paragraphs.size());
    }

    @Test
    public void lineFeedsConvertedToSpaces() {
        String paragraph = "Here is a really\nlong paragraph.\nWith multiple lines\nthat need to be converted";
        String results = TextFormatter.removeLineFeeds(paragraph);
        String expectedResults = "Here is a really long paragraph. With multiple lines that need to be converted";
        Assert.assertEquals(expectedResults, results);
    }

    @Test
    public void endOfLineFeedRemoved() {
        String paragraph = "Here is a really\nlong paragraph.\nWith multiple lines\nthat need to be converted\n";
        String results = TextFormatter.removeLineFeeds(paragraph);
        String expectedResults = "Here is a really long paragraph. With multiple lines that need to be converted";
        Assert.assertEquals(expectedResults, results);
    }

    @Test
    public void paragraphsCondenseAndLinesShorterThanEighty() throws Exception {
        String content = FileReader.readFileToString("article.txt");
        List<String> wrappedContent = TextFormatter.condenseAndWrapText(content);

        for(String line : wrappedContent) {
            Assert.assertTrue(line.length() < 81);
            System.out.println(line);
        }
    }

    @Test
    public void linesShorterThanEighty() throws Exception {
        List<String> lines = FileReader.readFile("article.txt");
        List<String> wrappedLines = TextFormatter.wrapText(lines);

        for(String line : wrappedLines) {
            Assert.assertTrue(line.length() < 81);
            System.out.println(line);
        }
    }
}
