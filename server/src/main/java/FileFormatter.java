import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class FileFormatter {
    public static void readUsingScanner(String filename) throws FileNotFoundException, URISyntaxException {

        File testFile = new File(FileFormatter.class.getResource(filename).toURI());
        Scanner scanner = new Scanner(testFile);
        scanner.useDelimiter(System.lineSeparator());
        while(scanner.hasNext()) {
            System.out.println(String.format("line: %s", scanner.next()));
        }
    }

    public static void readUsingFileUtils(String filename) throws IOException, URISyntaxException {
        File testFile = new File(FileFormatter.class.getResource(filename).toURI());
        String contents = FileUtils.readFileToString(testFile, Charset.defaultCharset());
        System.out.println(String.format("Read file to string: %s", contents));
    }
}
