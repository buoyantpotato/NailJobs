/**
 * Created by linzhou on 8/14/17.
 */
public class P408_ValidWordAbbr {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }

        // Time O(n), Space O(1)
        char[] charWord = word.toCharArray();
        char[] charAbbr = abbr.toCharArray();
        int i = 0, j = 0;
        while (i < charWord.length && j < charAbbr.length) {
            if (Character.isDigit(charAbbr[j])) {
                if (charAbbr[j] == '0') {
                    return false;
                }
                int num = 0;
                while (j < charAbbr.length && Character.isDigit(charAbbr[j])) {
                    num = num * 10 + charAbbr[j] - 48;
                    j++;
                }
                i += num;
            } else {
                if (charWord[i] != charAbbr[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == charWord.length && j == charAbbr.length;
    }
}
