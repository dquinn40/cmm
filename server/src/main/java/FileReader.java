import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class FileReader {
    public static String readFileToString(String filename) throws Exception {
        return FileUtils.readFileToString(
                new File(FileReader.class.getResource(filename).toURI()), Charset.defaultCharset());
    }

    public static List<String> readFile(String filename) throws Exception {
        return FileUtils.readLines(
                new File(FileReader.class.getResource(filename).toURI()), Charset.defaultCharset());
    }
}
