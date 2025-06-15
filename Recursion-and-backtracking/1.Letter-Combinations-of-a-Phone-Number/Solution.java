import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static List<String> letterCombinations(String digits) {
        List<String> stringList = new ArrayList<>();
        combinationGen(digits, 0, digits.length(), stringList, "", 0);
        return stringList;
    }

    public static void combinationGen(String digits, int i, int n, List<String> stringList, String str, int count) {
        // Base case
        if (i == n) {
            if(!str.isBlank()) {
                stringList.add(str);
            }
            return;
        }

        Map<Integer, String> ourMap = new HashMap<>();
        ourMap.put(2, "abc");
        ourMap.put(3, "def");
        ourMap.put(4, "ghi");
        ourMap.put(5, "jkl");
        ourMap.put(6, "mno");
        ourMap.put(7, "pqrs");
        ourMap.put(8, "tuv");
        ourMap.put(9, "wxyz");

        // Solve for one case
        //2
        int currentNum = digits.charAt(count) - '0';
        String currentString = ourMap.get(currentNum);
        int length = currentString.length();
        for (int j = 0; j <= length - 1; j++) {
            combinationGen(digits, i + 1, n, stringList, str + currentString.charAt(j), count + 1);
        }
    }

}
