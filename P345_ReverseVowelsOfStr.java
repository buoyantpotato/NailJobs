import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linzhou on 8/13/17.
 */
public class P345_ReverseVowelsOfStr {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        sol1(s);

        return sol2(s);
    }

    // Time O(n), Space O(1)
    private String sol1(String s) {
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I'));

        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < chs.length && !vowels.contains(chs[i])) {
                i++;
            }
            while (j >= 0 && !vowels.contains(chs[j])) {
                j--;
            }
            if (i <= j) {
                char temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;
                i++;
                j--;
            }
        }

        return String.valueOf(chs);
    }



    // Time O(n), Space O(1)  Switch is Faster!!!
    private String sol2(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowels(chs[i])) {
                i++;
            }
            while (i < j && !isVowels(chs[j])) {
                j--;
            }

            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }

        return new String(chs);
    }

    private boolean isVowels(char ch) {
        switch(ch) {
            case 'a': case 'e': case 'o': case 'u': case 'i':
            case 'A': case 'E': case 'O': case 'U': case 'I':
                return true;
            default:
                return false;
        }
    }
}
