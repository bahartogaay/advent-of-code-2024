import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(args[0]));
        StringBuilder fullText = new StringBuilder();
        String line;
        while ((line = bReader.readLine()) != null) fullText.append(line);
        String fullTextStr = fullText.toString();

        // part 1

        Matcher matcher = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\((\\d+)+,(\\d+)+\\)").matcher(fullTextStr);

        int result = 0;
        while (matcher.find()) {
            if (matcher.group(1) != null && matcher.group(2) != null)
                result += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }
        System.out.println(result);

        // end of part 1
        // part 2

        boolean isEnabled = true;
        result = 0;
        String match;
        matcher.reset();
        while (matcher.find()) {
            if ((match = matcher.group(0)) != null) {
                if (match.equals("do()"))           isEnabled = true;
                else if (match.equals("don't()"))   isEnabled = false;
            }
            if (isEnabled && matcher.group(1) != null && matcher.group(2) != null)
                result += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }
        System.out.println(result);

        // end of part 2

        bReader.close();
    }
}
