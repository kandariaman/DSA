import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> listPatterns = new ArrayList<>();
        checkParanthesis(n, 0, 0,"", listPatterns);
        return listPatterns;
    }

    public static void checkParanthesis(int max, int open, int close, String pattern, List<String> listPatterns) {
        if(pattern.length() == max * 2) {
            listPatterns.add(pattern);
            return;
        }

        if(open < max)
            checkParanthesis(max, open + 1, close, pattern + "(", listPatterns);

        if(close < open)
            checkParanthesis(max, open, close + 1, pattern + ")",listPatterns);
    }
}
