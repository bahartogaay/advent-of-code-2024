import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Solution04 {

    // this solution is ASS

    public static long checkHorizontals(char[][] charArr, int len) {
        long count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 2; j++) {
                if (charArr[i][j] == 'X' && charArr[i][j + 1] == 'M' && charArr[i][j + 2] == 'A'
                        && charArr[i][j + 3] == 'S') {
                    count++;
                }
                if (charArr[i][j] == 'S' && charArr[i][j + 1] == 'A' && charArr[i][j + 2] == 'M'
                        && charArr[i][j + 3] == 'X') {
                    count++;
                }
            }

        }
        return count;
    }

    public static long checkVerticals(char[][] charArr, int len) {
        long count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 3; j++) {
                if (charArr[j][i] == 'X' && charArr[j + 1][i] == 'M' && charArr[j + 2][i] == 'A'
                        && charArr[j + 3][i] == 'S') {
                    count++;
                }
                if (charArr[j][i] == 'S' && charArr[j + 1][i] == 'A' && charArr[j + 2][i] == 'M'
                        && charArr[j + 3][i] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static long checkDiagonal(char[][] charArr, int len) {
        long count = 0;
        for (int i = 0; i < len - 3; i++) {
            for (int j = 0; j < len - 3; j++) {
                if (charArr[i][j] == 'X' && charArr[i + 1][j + 1] == 'M' && charArr[i + 2][j + 2] == 'A'
                        && charArr[i + 3][j + 3] == 'S') {
                    count++;
                }
                if (charArr[i][j] == 'S' && charArr[i + 1][j + 1] == 'A' && charArr[i + 2][j + 2] == 'M'
                        && charArr[i + 3][j + 3] == 'X') {
                    count++;
                }
            }
        }
        for (int i = 0; i < len - 3; i++) {
            for (int j = 3; j < len; j++) {
                if (charArr[i][j] == 'X' && charArr[i + 1][j - 1] == 'M' && charArr[i + 2][j - 2] == 'A'
                        && charArr[i + 3][j - 3] == 'S') {
                    count++;
                }
                if (charArr[i][j] == 'S' && charArr[i + 1][j - 1] == 'A' && charArr[i + 2][j - 2] == 'M'
                        && charArr[i + 3][j - 3] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(args[0])).stream().collect(Collectors.toList());

        char[][] charArr = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            charArr[i] = lines.get(i).toCharArray();
        }
        int len = charArr[0].length;

        // part 1
        long totalCount = 0;
        totalCount += checkHorizontals(charArr, len);
        totalCount += checkVerticals(charArr, len);
        totalCount += checkDiagonal(charArr, len);

        System.out.println(totalCount);
        // end of part 1
        // part 2
        long count = 0;

        for (int i = 1; i < len - 1; i++) {
            for (int j = 1; j < len - 1; j++) {
                if (charArr[i][j] == 'A') {
                    if ((int) (charArr[i - 1][j - 1] + charArr[i + 1][j + 1]) == (int) ('S' + 'M') &&
                            (int) (charArr[i - 1][j + 1] + charArr[i + 1][j - 1]) == (int) ('S' + 'M')) {
                        count++;
                    }

                }
            }
        }
        System.out.println(count);
        // end of part 2

    }

}
