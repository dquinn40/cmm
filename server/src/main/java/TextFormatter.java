import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFormatter {

    public static List<String> wrapText(List<String> lines) {
        List<String> wrappedLines = new ArrayList<>();
        for(String line : lines) {
            if(line.length() < 81) {
                wrappedLines.add(line);
            } else {
                wrappedLines.addAll(wrapLine(line, 80));
            }
        }
        return wrappedLines;
    }

    public static List<String> condenseAndWrapText(String content) throws Exception {
        List<String> paragraphs = tokenizeParagraphs(content);
        List<String> paragraphWithoutLineFeeds = new ArrayList<>();
        for(String paragraph : paragraphs) {
            paragraphWithoutLineFeeds.add(removeLineFeeds(paragraph));
        }

        List<String> wrappedParagraphs = new ArrayList<>();
        for(String flattenedParagraph : paragraphWithoutLineFeeds) {
            wrappedParagraphs.addAll(wrapLine(flattenedParagraph, 80));
            wrappedParagraphs.add("\n");
        }

        return wrappedParagraphs;
    }

    public static List<String> tokenizeParagraphs(String text) {
        return Arrays.asList(text.split("\n\n"));
    }

    public static String removeLineFeeds(String paragraph) {
        return paragraph.replace("\n", " ").trim();
    }

    public static List<String> wrapLine(String wrapText, int charCount) {
        List<String> lines = new ArrayList<>();
        int startPost = 0;
        while (startPost < wrapText.length()) {
            if (startPost + charCount < wrapText.length()) {
                int splitIdx = wrapText.substring(startPost, (startPost + charCount)).lastIndexOf(" ");
                lines.add(wrapText.substring(startPost, startPost + splitIdx));
                startPost = startPost + splitIdx + 1;
            } else {
                lines.add(wrapText.substring(startPost, wrapText.length()));
                startPost = wrapText.length() + 1;
            }

        }
        return lines;
    }
}
