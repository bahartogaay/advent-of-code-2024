import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution02 {

    public static boolean checkSafe(List<Integer> list) {
        int direction = list.get(0).compareTo(list.get(1));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) != direction)
                return false;
            if (Math.abs(list.get(i) - list.get(i - 1)) > 3
                    || Math.abs(list.get(i) - list.get(i - 1)) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean problemDampener(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.remove(i);
            if (checkSafe(temp))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(args[0]));
        List<List<Integer>> intList = new ArrayList<>();
        intList = bReader.lines()
                .map(line -> Stream.of(line.split(" "))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        // part 1

        int safeCount = (int) intList.stream().filter(line -> checkSafe(line) == true).count();

        System.out.println(safeCount);

        // end of part 1
        // part 2

        int pdSafeCount = (int) intList.stream().filter(line -> checkSafe(line) == false)
                .filter(line -> problemDampener(line) == true).count();

        pdSafeCount += safeCount;
        System.out.println(pdSafeCount);

        // end of part 2

        bReader.close();

    }
}