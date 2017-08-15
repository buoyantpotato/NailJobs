/**
 * Created by linzhou on 8/14/17.
 */
public class P058_LenOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        sol1(s);
        return sol2(s);
    }

    private int sol1(String s) {
        char[] chs = s.toCharArray();
        int i = chs.length - 1;
        while (i >= 0 && chs[i] == ' ') {
            i--;
        }
        if (i < 0) {
            return 0;
        }

        int j = i;
        while (j >= 0 && chs[j] != ' ') {
            j--;
        }

        return s.substring(j + 1, i + 1).length();
    }

    private int sol2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
