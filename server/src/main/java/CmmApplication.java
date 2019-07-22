import java.util.List;

public class CmmApplication {
    public static void main(String[] args) {
        try {
            wrapLines();
            System.out.println("\n\n\n#############################################\n\n\n");
            wrapAndCondenseParagraphs();
        } catch (Exception e) {
            System.out.println("Unable to process file");
            e.printStackTrace();
        }
    }

    private static void wrapLines() throws Exception {
        List<String> lines = FileReader.readFile("article.txt");
        List<String> wrappedLines = TextFormatter.wrapText(lines);

        for(String line : wrappedLines) {
            System.out.println(line);
        }
    }

    private static void wrapAndCondenseParagraphs() throws Exception {
        String content = FileReader.readFileToString("article.txt");
        List<String> wrappedLines = TextFormatter.condenseAndWrapText(content);

        for(String line : wrappedLines) {
            System.out.println(line);
        }
    }
}
