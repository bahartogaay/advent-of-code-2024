import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Solution06 {

    // yanderedev would be so proud omg

    public static char turnRight(char ch) {
        if (ch == '^')
            return '>';
        else if (ch == '>')
            return 'v';
        else if (ch == 'v')
            return '<';
        else if (ch == '<')
            return '^';
        return 'N';
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(args[0])).stream().collect(Collectors.toList());

        char[][] charArr = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            charArr[i] = lines.get(i).toCharArray();
        }
        int len = charArr[0].length;

        // part 1

        char guard = '-';
        int i = 0, j = 0;
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                if (charArr[i][j] == '^') {
                    guard = charArr[i][j];
                    break;
                }
            }
            if (guard != '-')
                break;
        }

        while (true) {
            if (i == len - 1 || j == len - 1)
                break;
            else {
                if (guard == '^') {
                    if (charArr[i - 1][j] == '#') {
                        guard = turnRight(guard);
                        continue;
                    }
                    charArr[i--][j] = 'X';
                    charArr[i][j] = guard;
                } else if (guard == '>') {
                    if (charArr[i][j + 1] == '#') {
                        guard = turnRight(guard);
                        continue;
                    }
                    charArr[i][j++] = 'X';
                    charArr[i][j] = guard;
                } else if (guard == '<') {
                    if (charArr[i][j - 1] == '#') {
                        guard = turnRight(guard);
                        continue;
                    }
                    charArr[i][j--] = 'X';
                    charArr[i][j] = guard;
                } else if (guard == 'v') {
                    if (charArr[i + 1][j] == '#') {
                        guard = turnRight(guard);
                        continue;
                    }
                    charArr[i++][j] = 'X';
                    charArr[i][j] = guard;
                }

            }
        }

        long output = 0;

        // Stream.of(charArr).map(Arrays::toString).forEach(System.out::println);

        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                if (charArr[k][l] == 'X') {
                    output++;
                }
            }
        }

        System.out.println(output + 1);

        // end of part 1
        // part 2

        

    }

}
