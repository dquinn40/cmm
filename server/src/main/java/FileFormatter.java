import java.util.ArrayList;
import java.util.List;

public class FileFormatter {
    public static List<String> wrapText(List<String> lines) throws Exception {
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

    private static int getLastSpaceInString(String str) throws Exception {
        return str.lastIndexOf(" ");
    }
}
