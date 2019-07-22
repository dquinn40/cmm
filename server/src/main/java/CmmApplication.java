import java.util.List;

public class CmmApplication {
    public static void main(String[] args) {
        try {
            showWrapLinesImplementation();
            System.out.println("\n\n\n#############################################\n\n\n");
            shapWrapAndCondenseParagraphsImplementation();
        } catch (Exception e) {
            System.out.println("Unable to process file");
            e.printStackTrace();
        }
    }

    private static void showWrapLinesImplementation() throws Exception {
        List<String> lines = FileReader.readFile("article.txt");
        List<String> wrappedLines = TextFormatter.wrapText(lines);

        for(String line : wrappedLines) {
            System.out.println(line);
        }
    }

    private static void shapWrapAndCondenseParagraphsImplementation() throws Exception {
        String content = FileReader.readFileToString("article.txt");
        List<String> wrappedLines = TextFormatter.condenseAndWrapText(content);

        for(String line : wrappedLines) {
            System.out.println(line);
        }
    }
}
