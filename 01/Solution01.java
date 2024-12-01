import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution01 {

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        Scanner sc = new Scanner(new File(filePath));
        int i = 0, j = 0, result = 0;
        List<Integer> arrList = new ArrayList<>();
        List<Integer> arrList2 = new ArrayList<>();

        while (sc.hasNextInt()) {
            arrList.add(sc.nextInt());
            arrList2.add(sc.nextInt());
        }
        sc.close();

        // part 1

        Collections.sort(arrList);
        Collections.sort(arrList2);

        for (i = 0; i < arrList.size(); i++) {
            result += Math.abs(arrList.get(i) - arrList2.get(i));
        }

        // end of part 1
        // part 2

        int similarityScore = 0;

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (j = 0; j < arrList2.size(); j++) {
            if (hashMap.containsKey(arrList2.get(j))) {
                hashMap.put(arrList2.get(j), hashMap.get(arrList2.get(j)) + 1);
            } else {
                hashMap.put(arrList2.get(j), 1);
            }
        }

        // hashMap.forEach((key, value) -> System.out.println(key + " " + value));

        for (i = 0; i < arrList.size(); i++) {
            if (hashMap.containsKey(arrList.get(i))) {
                similarityScore += arrList.get(i) * hashMap.get(arrList.get(i));
            }
        }

        // end of part 2

        System.out.println(result);
        System.out.println(similarityScore);
    }
}